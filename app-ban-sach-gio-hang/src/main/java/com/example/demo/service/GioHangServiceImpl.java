package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.ItemGioHang;

@SessionScope
@Service
public class GioHangServiceImpl implements GioHangService{
	Map<Integer, ItemGioHang> maps = new HashMap<Integer, ItemGioHang>();
	
	private final String ITEM_CACHE = "ITEM";
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Integer, ItemGioHang> hashOperations;

	@PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void addCartItem(ItemGioHang cart) {
		ItemGioHang cartItem = maps.get(cart.getId());

		if(cartItem == null) {
			hashOperations.put(ITEM_CACHE, cartItem.getId(), cart);
			maps.put(cart.getId(), cart);
		}
		else {
			hashOperations.put(ITEM_CACHE, cartItem.getId(), cart);
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	} 
	@Override
	public boolean remove(int id) {
		if(maps.remove(id) != null) {
			hashOperations.delete(ITEM_CACHE, id);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public ItemGioHang update(int sachId, int quantity) {
		ItemGioHang cart = maps.get(sachId);
		if(quantity == 0) {
			cart.setQuantity(1);
		}
		else {
			cart.setQuantity(quantity);
		}
		return cart;
	}
	
	@Override
	public boolean increaseQuantity(int sachId) {
		try {
			ItemGioHang cart = maps.get(sachId);
			cart.setQuantity(cart.getQuantity() + 1);
			
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	@Override
	public boolean decreaseQuantity(int sachId) {
		try {
			ItemGioHang cart = maps.get(sachId);
			if(cart.getQuantity() > 1) {
				cart.setQuantity(cart.getQuantity() - 1);
			}
			else{
				maps.remove(sachId);
			}
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	@Override
	public void clear() {
		maps.clear();
	}
	
	@Override
	public Collection<ItemGioHang> getAllItems(){
		return maps.values();
	}
	
	@Override
	public int getCount() {
		return maps.values().size();
	}
	
	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble((item) -> {
			return item.getQuantity() * item.getPrice();
		}).sum();
	}
}
