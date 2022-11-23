package com.example.se.nhom5.appbansach.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.se.nhom5.appbansach.entity.LoaiSach;

@Repository
public interface LoaiSachRepository extends JpaRepository<LoaiSach , Integer>{
    
}   
