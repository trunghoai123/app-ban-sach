package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LoaiSach;
 

public interface LoaiSachService {
    public List<LoaiSach> findAll();
    public LoaiSach findLoaiSachByMaLoai(int maLoai);
    public void deleteLoaiSachById(int maLoai);
}
