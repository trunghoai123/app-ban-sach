package com.example.se.nhom5.appbansach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.se.nhom5.appbansach.dao.LoaiSachRepository;
import com.example.se.nhom5.appbansach.entity.LoaiSach;

@Service
public class LoaiSachServiceImp implements LoaiSachService{
    @Autowired 
    private LoaiSachRepository loaiSachRepository;
    @Override
    public List<LoaiSach> findAll() {
        return loaiSachRepository.findAll();
    }

    @Override
    public LoaiSach findLoaiSachByMaLoai(int maLoai) {
        return null;
    }

    @Override
    public void deleteLoaiSachById(int maLoai) {
        loaiSachRepository.deleteById(maLoai);
    }
 
}
