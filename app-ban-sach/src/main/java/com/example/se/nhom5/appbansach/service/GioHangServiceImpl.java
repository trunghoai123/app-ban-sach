package com.example.se.nhom5.appbansach.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.se.nhom5.appbansach.entity.ItemGioHang;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class GioHangServiceImpl implements GioHangService{
	Map<Integer, ItemGioHang> maps = new HashMap<Integer, ItemGioHang>();
	
	@Override
	public void addCartItem(ItemGioHang cart) {
		ItemGioHang cartItem = maps.get(cart.getId());

		if(cartItem == null) {
			maps.put(cart.getId(), cart);
		}
		else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	} 
	@Override
	public boolean remove(int id) {
		if(maps.remove(id) != null) {
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
