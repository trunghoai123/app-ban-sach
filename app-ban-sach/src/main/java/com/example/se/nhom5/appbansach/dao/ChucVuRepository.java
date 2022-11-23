package com.example.se.nhom5.appbansach.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.se.nhom5.appbansach.entity.ChucVu;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer>{
    
}
