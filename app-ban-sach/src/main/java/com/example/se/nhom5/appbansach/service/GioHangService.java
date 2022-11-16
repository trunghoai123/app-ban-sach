package com.example.se.nhom5.appbansach.service;
 
import java.util.Collection;
import java.util.List;

import com.example.se.nhom5.appbansach.entity.ItemGioHang;

public interface GioHangService {

	void addCartItem(ItemGioHang cart);

	void clear();

	boolean remove(int id);

	ItemGioHang update(int sachId, int quantity);

	Collection<ItemGioHang> getAllItems();

	int getCount();

	double getAmount();

	boolean decreaseQuantity(int sachId);

	boolean increaseQuantity(int sachId);
	
	

}
