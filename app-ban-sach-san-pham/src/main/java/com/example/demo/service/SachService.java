package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Sach; 

public interface SachService {
    public List<Sach> findAll();
    public Sach getSachByMaSach(int maSach);
    public Sach save(Sach sach);
    public List<Sach> getSachByKhoanGia(double giaMin, double giaMax);
    public List<Sach> getSachsByNameASC();
    public List<Sach> getSachsByNameDESC();
    public List<Sach> getSachByTenLoaiSach(String tenLoai);
    public Sach getSachInCache(int maSach) ;
	List<Sach> getSachsByTenSach(String tenSach);   
	List<Sach> getSachsBySearch(String tenSach, String maLoai, String giaTu, String giaDen, String sort); 
}
