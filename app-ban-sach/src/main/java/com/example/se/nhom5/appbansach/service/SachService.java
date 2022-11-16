package com.example.se.nhom5.appbansach.service;

import java.util.List;

import com.example.se.nhom5.appbansach.entity.Sach;

public interface SachService {
    public List<Sach> findAll();
    public Sach getSachByMaSach(int maSach);
    public Sach save(Sach sach);
    public List<Sach> getSachByKhoanGia(double giaMin, double giaMax);
    public List<Sach> getSachsByNameASC();
    public List<Sach> getSachsByNameDESC();
    public List<Sach> getSachByTenLoaiSach(String tenLoai);
}
