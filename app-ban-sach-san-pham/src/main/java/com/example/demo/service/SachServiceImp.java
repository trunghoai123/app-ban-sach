package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.SachRepository;
import com.example.demo.entity.Sach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

@Service
public class SachServiceImp implements SachService{
    @Autowired
    private SachRepository sachRepository;
    @Override
    public List<Sach> findAll() {
        // TODO Auto-generated method stub
        return sachRepository.findAll();
    }

    @Override
    public Sach getSachByMaSach(int maSach) {
        // TODO Auto-generated method stub
        return sachRepository.getSachByMaSach(maSach);
    }

    @Override
    public Sach save(Sach sach) {
        // TODO Auto-generated method stub
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
