package com.example.se.nhom5.appbansach.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.se.nhom5.appbansach.entity.LoaiSach;
import com.example.se.nhom5.appbansach.entity.Sach;
import com.example.se.nhom5.appbansach.entity.NhaXuatBan;
import com.example.se.nhom5.appbansach.service.LoaiSachService;
import com.example.se.nhom5.appbansach.service.SachService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.vavr.collection.Stream;
  
@RestController
@RequestMapping("/api")
public class SachController {
	
    @Autowired
    private SachService sachService;
    @Autowired
    private LoaiSachService loaiSachService;
    
    @Autowired
	private RestTemplate restTemplate;
    
    
    private static final String BASE_URL = "http://localhost:8083/";

	private static final String SERVICE_A = "serviceA";
	int count = 1;
	

    
//    http://localhost:8099/api/sachs
    @GetMapping("/sachs")
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceFallback")
    public List<Sach> findAllSach(){
    	String url = BASE_URL + "sach/sachs";
    	
		return restTemplate.getForObject(url,ArrayList.class);
    }
    
//    http://localhost:8099/api/sachs/giaSach?giaMin=100000&giaMax=150000
    @GetMapping("/sachs/giaSach")
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceFallback")
    public List<Sach> getSachsByKhoangGia(@RequestParam("giaMin") int giaMin, @RequestParam("giaMax") int giaMax){
    	String url = BASE_URL + "sach/sachs/giaSach?giaMin="+giaMin+"&giaMax="+giaMax;
		return restTemplate.getForObject(url,ArrayList.class);
    }
    
    
//    http://localhost:8099/api/sachs/sort/asc
    @GetMapping("/sachs/sort/asc")
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceFallback")
    public List<Sach> getSachsByNameASC(){
    	String url = BASE_URL + "sach/sachs/sort/asc";
		return restTemplate.getForObject(url,ArrayList.class);
    } 
    
    
    
    //------------------------------------------------------------------//
    
//    http://localhost:8099/api/sachs/sort/desc
    @GetMapping("/sachs/sort/desc")
    @Retry(name = SERVICE_A,fallbackMethod = "serviceFallback")
    public List<Sach> getSachsByNameDESC(){
    	
    	String url = BASE_URL + "sach/sachs/sort/desc";
		System.out.println("Retry method called " + count++ + " times at " + new Date());
		return restTemplate.getForObject(url,ArrayList.class);
    }
    
//    http://localhost:8099/api/sachs/find?maSach=2
    @GetMapping("/sachs/find")
    public Sach findSachByMaSach(@RequestParam("maSach") int maSach) {
        return sachService.getSachByMaSach(maSach);
    }
    
//    http://localhost:8099/api/loaiSachs
    @GetMapping("/loaiSachs")
    @Retry(name = SERVICE_A,fallbackMethod = "serviceFallback")
    public List<LoaiSach> getLoaiSachs() { 
    	
    	String url = BASE_URL + "sach/loaiSachs";
		System.out.println("Retry method called " + count++ + " times at " + new Date());
		return restTemplate.getForObject(url,ArrayList.class);
    }
    
//    http://localhost:8099/api/sachs/loaiSach?tenLoai=Lịch sử
    @GetMapping("/sachs/loaiSach")
    @Retry(name = SERVICE_A,fallbackMethod = "serviceFallback")
    public List<Sach> getSachByTenLoaiSach(@RequestParam("tenLoai") String tenLoai) {
    	
    	String url = BASE_URL + "sach/sachs/loaiSach?tenLoai="+tenLoai;
		System.out.println("Retry method called " + count++ + " times at " + new Date());
		return restTemplate.getForObject(url,ArrayList.class);
    }
    
    public List<Sach> serviceFallback(Exception e) {		
		return Stream.of(
				new Sach(70, "Who can made it 2 22","Nelson Demille", 777,107000.0, "https://i.imgur.com/7qsZjQq.jpg", new LoaiSach (2, "Kinh Dị"), new NhaXuatBan (3, "Nhà Xuất Bản Trẻ"), null),
				new Sach(2, "Một thoáng rực rỡ","Vương Quốc Vinh", 6484,96000.0, "https://i.imgur.com/PyoarFm.jpg", new LoaiSach (2, "Kinh Dị"), new NhaXuatBan (3, "Nhà Xuất Bản Trẻ"), null),
				new Sach(3, "Yêu thầm","Vũ Đức Hiếu", 120,133000.0, "https://i.imgur.com/VUHid8V.jpg", new LoaiSach (3, "Lãng Mạn"), new NhaXuatBan (4, "Nhà Xuất Bản Tổng Hợp TP HCM"), null),
				new Sach(4, "Lịch sử thế giới","Robert Kinston", 59,160000.0, "https://i.imgur.com/tfUqyPk.jpg", new LoaiSach (4	, "Lịch Sử"), new NhaXuatBan (5, "Nhà Xuất Bản Chính Trị Quốc Gia Sự Thật"), null),
				new Sach(5, "Lịch sử do thái","Paul Johnson", 134,272000.0, "https://i.imgur.com/YqPJb4I.jpgg", new LoaiSach (4	, "Lịch Sử"), new NhaXuatBan (3, "Nhà Xuất Bản Trẻ"), null)).collect(Collectors.toList());
	}
}
