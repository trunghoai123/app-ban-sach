package com.example.demo.controller;
 
 
import java.util.Collection;

import com.example.demo.entity.ItemGioHang;
import com.example.demo.entity.Sach;
import com.example.demo.service.GioHangService;
import com.example.demo.service.SachService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

  
@RestController
@RequestMapping("/cart")
public class GioHangController {
	@Autowired
	GioHangService gioHangService;
	
	@Autowired
	SachService sachService;
	// http://localhost:8081/cart/sachs
   @GetMapping("sachs")
   public Collection<ItemGioHang> showAllItemGioHang() { 
	   return gioHangService.getAllItems();
   }
   //http://localhost:8081/cart/add/2
   @GetMapping("add/{idSach}")
   public boolean themSachVaoGioHang(@PathVariable int idSach) { 
	   try {
		   Sach sach = sachService.getSachByMaSach(idSach);
		   if(sach != null) {
			   ItemGioHang item = new ItemGioHang();
			   item.setId(sach.getMaSach());
			   item.setProductName(sach.getTenSach());
			   item.setPrice(sach.getDonGia());
			   item.setQuantity(1); 
			   gioHangService.addCartItem(item);
		   }
		   return true;
		} catch (Exception e) {
			return false;
		}
    }
   //http://localhost:8081/cart/clear - xoa het gio hang
   @GetMapping("clear")
   public boolean clearGioHang() {  
	   try {
		   gioHangService.clear();
	} catch (Exception e) {
		return false;
	} 
	   return true; 
   }
   //http://localhost:8081/cart/remove/2 - xoa 1 item trong gio hang
   @GetMapping("remove/{idSach}")
   public String xoaSachKhoiGioHang(@PathVariable int idSach) { 
	   try {
		   if(gioHangService.remove(idSach)) {
			   return "Xoa Thanh Cong";
		   }
		   else {
			   return "Khong xoa duoc";
		   } 
		} catch (Exception e) {
			return "Xoa Khong Thanh Cong";
		}
    }
   //http://localhost:8081/cart/update?id=2&qty=4 - cập nhật số lượng sách trong giỏ hàng
   @GetMapping("update")
   public boolean updateQuantityGioHang(@RequestParam("id") int idSach, @RequestParam("qty") int quantity) { 
	   if(gioHangService.update(idSach, quantity) != null) {
		   return true;
	   }
	   else {
		   return false;
	   }
    }
 //http://localhost:8081/cart/increase/2 - Tăng số lượng của sách trong giỏ hàng
   @GetMapping("increase/{idSach}")
   public boolean increaseQuantityGioHang(@PathVariable int idSach) { 
	   return gioHangService.increaseQuantity(idSach);
    }
   //http://localhost:8081/cart/decrease/2 - giảm số lượng của sách trong giỏ hàng
   @GetMapping("decrease/{idSach}")
   public boolean decreaseQuantityGioHang(@PathVariable int idSach) { 
	   return gioHangService.decreaseQuantity(idSach);
    }
   
}
