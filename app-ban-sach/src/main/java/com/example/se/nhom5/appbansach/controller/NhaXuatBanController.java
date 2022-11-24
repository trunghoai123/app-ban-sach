package com.example.se.nhom5.appbansach.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.se.nhom5.appbansach.entity.NhaXuatBan;
import com.example.se.nhom5.appbansach.entity.Sach;
import com.example.se.nhom5.appbansach.service.LoaiSachService;
import com.example.se.nhom5.appbansach.service.NhaXuatBanServiceImp;
import com.example.se.nhom5.appbansach.service.SachService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.vavr.collection.Stream;

@RestController
@RequestMapping("/nhaxuatban")
public class NhaXuatBanController {

	@Autowired
	private NhaXuatBanServiceImp nxb;
	@Autowired
	private SachService sachService;
	@Autowired
	private RestTemplate restTemplate;

	private static final String BASE_URL = "http://localhost:8083/";

	private static final String SERVICE_A = "serviceA";

	int count = 1;

	@GetMapping("/nhaxuatbans")
	public List<NhaXuatBan> findAll() {
		List<NhaXuatBan> sachs = nxb.findAll();
		return sachs;
	}

	@GetMapping("/find")
	public NhaXuatBan findSachByMaSach(@RequestParam("maNXB") int maNXB) {
		return nxb.findNhaXuatBanByMaNXB(maNXB);
	}

	
	//http://localhost:8099/nhaxuatban/getAllSachByMaNXB?maNXB=2
	@GetMapping("/getAllSachByMaNXB")
//	@Retry(name = SERVICE_A,fallbackMethod = "serviceAFallback")
	@CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
//	@RateLimiter(name = SERVICE_A)
	public Object[] getAllSach_ByMaNXB(@RequestParam("maNXB") int maNXB) {

		String url = BASE_URL + "sach/sachs/findSachByNXB?maNXB="+maNXB;
		System.out.println("Retry method called " + count++ + " times at " + new Date());
		return restTemplate.getForObject(url, Object[].class);
	}
	
	//http://localhost:8099/nhaxuatban/getAllSachByTenNXB?tenNXB=Nhà Xuất bản trẻ
	@GetMapping("/getAllSachByTenNXB")
//	@Retry(name = SERVICE_A,fallbackMethod = "serviceAFallback")
	@CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
//	@RateLimiter(name = SERVICE_A)
	public Object[] serviceA(@RequestParam("tenNXB") String tenNXB) {

		String url = BASE_URL + "sach/sachs/findSachByTenNXB?tenNXB="+tenNXB;
		System.out.println("Retry method called " + count++ + " times at " + new Date());
		return restTemplate.getForObject(url, Object[].class);
	}
	
	
	

	public Object[] serviceAFallback(Exception e) {

		String url = BASE_URL + "sach/sachs/findSachByNXB?maNXB="+2;
		System.out.println("Retry method called " + count++ + " times at " + new Date());
		System.out.println(url);
		Object[] o=( sachService.findAll().toArray());
		
		
//		List<String> a=Arrays.asList("Call api is error");
//		Object[] o=a.toArray();
//		return o;
		
		return o;
	}

}
