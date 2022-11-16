package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.LoaiSach;
import com.example.demo.entity.Sach;
import com.example.demo.service.LoaiSachService;
import com.example.demo.service.SachService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 

@RestController
@RequestMapping("/sach")
public class SachController {
	
    @Autowired
    private SachService sachService;
    @Autowired
    private LoaiSachService loaiSachService;
    
//    http://localhost:8088/api/sachs
    @GetMapping("/sachs")
    public List<Sach> findAllSach(){
    	List<Sach> sachs = sachService.findAll();
    	if(sachs.size() > 0) {
    		sachs.forEach((sach) -> {
    			System.out.println(sach);
    		});
    	}
        return sachs;
    }
    
//    http://localhost:8088/api/sachs/giaSach?giaMin=100000&giaMax=150000
    @GetMapping("/sachs/giaSach")
    public List<Sach> getSachsByKhoangGia(@RequestParam("giaMin") int giaMin, @RequestParam("giaMax") int giaMax){
        return sachService.getSachByKhoanGia(giaMin, giaMax);
    }
    
//    http://localhost:8088/api/sachs/sort/asc
    @GetMapping("/sachs/sort/asc")
    public List<Sach> getSachsByNameASC(){
        return sachService.getSachsByNameASC();
    } 
    
//    http://localhost:8088/api/sachs/sort/desc
    @GetMapping("/sachs/sort/desc")
    public List<Sach> getSachsByNameDESC(){
        return sachService.getSachsByNameDESC();
    }
    
//    http://localhost:8088/api/sachs/find?maSach=2
    @GetMapping("/sachs/find")
    public Sach findSachByMaSach(@RequestParam("maSach") int maSach) {
        return sachService.getSachByMaSach(maSach);
    }
    
//    http://localhost:8088/api/loaiSachs
    @GetMapping("/loaiSachs")
    public List<LoaiSach> getLoaiSachs() {  
        return loaiSachService.findAll();
    }
    
//    http://localhost:8088/api/sachs/loaiSach?tenLoai=Lịch sử
    @GetMapping("/sachs/loaiSach")
    public List<Sach> getSachByTenLoaiSach(@RequestParam("tenLoai") String tenLoai) {
        return sachService.getSachByTenLoaiSach(tenLoai);
    }
}
