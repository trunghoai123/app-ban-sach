package com.example.se.nhom5.appbansach.service;

import java.util.List;

import com.example.se.nhom5.appbansach.entity.LoaiSach;

public interface LoaiSachService {
    public List<LoaiSach> findAll();
    public LoaiSach findLoaiSachByMaLoai(int maLoai);
    public void deleteLoaiSachById(int maLoai);
}
