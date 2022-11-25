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
    
//  http://localhost:8099/api/sachs/giaSach?giaMin=100000&giaMax=150000
  @GetMapping("/sachs/search")
  @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceFallback")
  public List<Sach> getSachsBySearch(
  		@RequestParam(name = "tenSach", required = false) String tenSach,
  		@RequestParam(name = "maLoai", required = false) String maLoai,
  		@RequestParam(name = "giaTu", required = false) String giaTu,
  		@RequestParam(name = "giaDen", required = false) String giaDen,
  		@RequestParam(name = "sort", required = false) String sort){
	String tenSach1 = "";
	if(tenSach != null) {
		tenSach1 = "&tenSach=" + tenSach; 
	}
	String maLoai1 = "" ;
	if(maLoai != null) {
		maLoai1 = "&maLoai=" + maLoai; 
	}
	String giaTu1 = "" ;
	if(giaTu != null) {
		giaTu1 = "&giaTu=" + giaTu; 
	}
	String giaDen1 = "" ;
	if(giaDen != null) {
		giaDen1 = "&giaDen=" + giaDen; 
	}
	String sort1 = "" ;
	if(sort != null) {
		sort1 = "&sort=" + sort; 
	}
	String url = BASE_URL + "sach/sachs/search?" + tenSach1 + maLoai1 + giaTu1 + giaDen1 + sort1;
//	  String url = BASE_URL + "sach/sachs/search?tenSach="+tenSach+"&maLoai="+maLoai+"&giaTu="+giaTu+"&giaDen="+giaDen+"&sort="+sort;
	  System.out.println(url);
		return restTemplate.getForObject(url,ArrayList.class);
  }
    
    @GetMapping("/sachs/search2")
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceFallback")
    public List<Sach> getSachSeach(@RequestParam(name = "tenSach", required = false) String tenSach,
    		@RequestParam(name = "maLoai", required = false) String maLoai,
    		@RequestParam(name = "giaTu", required = false) String giaTu,
    		@RequestParam(name = "giaDen", required = false) String giaDen,
    		@RequestParam(name = "sort", required = false) String sort){
    		String url = BASE_URL + "sach/sachs/search?tenSach="+tenSach+"&maLoai="+maLoai+"&giaTu="+giaTu+"&giaDen="+giaDen+"&sort="+sort;
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
				new Sach(0, "","", 0,0, "", new LoaiSach (0, ""), new NhaXuatBan (0, ""), null),
				new Sach(0, "","", 0,0, "", new LoaiSach (0, ""), new NhaXuatBan (0, ""), null),
				new Sach(0, "","", 0,0, "", new LoaiSach (0, ""), new NhaXuatBan (0, ""), null),
				new Sach(0, "","", 0,0, "", new LoaiSach (0, ""), new NhaXuatBan (0, ""), null),
				new Sach(0, "","", 0,0, "", new LoaiSach (0, ""), new NhaXuatBan (0, ""), null)).collect(Collectors.toList());
	}
}
