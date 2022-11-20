package com.example.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.dao.SachRepository;
import com.example.demo.entity.Sach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestTemplate;
@Service
public class SachServiceImp implements SachService{
	static String url_billing = "http://localhost:8082/cart";
	private static RestTemplate RestTemplate = new RestTemplate();
	private final String SACH_CACHE = "SACH";
	
	@Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Integer, Sach> hashOperations;
     
 
    @Autowired
    private SachRepository sachRepository;
    
    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public List<Sach> findAll() {
        // TODO Auto-generated method stub
        return sachRepository.findAll();
    }

    @Override
    public Sach getSachByMaSach(int maSach) {
    	
        return sachRepository.getSachByMaSach(maSach);
    }
    @Override
    public Sach getSachInCache(int maSach) {
    	
        return sachRepository.getSachByMaSach(maSach);
    }
    @Override
    public Sach save(Sach sach) {
    	hashOperations.put(SACH_CACHE, sach.getMaSach(), sach);
        return sachRepository.save(sach);
    }

    @Override
    public List<Sach> getSachByKhoanGia(double giaMin, double giaMax) {
        // TODO Auto-generated method stub
        return sachRepository.getSachByKhoanGia(giaMin, giaMax);
    }

    @Override
    public List<Sach> getSachsByNameASC() {
        // TODO Auto-generated method stub
        return sachRepository.getSachsByNameASC();
    }

    @Override
    public List<Sach> getSachsByNameDESC() {
        // TODO Auto-generated method stub
        return sachRepository.getSachsByNameDESC();
    }

    @Override
    public List<Sach> getSachByTenLoaiSach(String tenLoai) {
        // TODO Auto-generated method stub
        return sachRepository.getSachsByTenLoaiSach(tenLoai);
    }


    
}
