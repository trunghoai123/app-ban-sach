package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.LoaiSachRepository;
import com.example.demo.entity.LoaiSach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

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
