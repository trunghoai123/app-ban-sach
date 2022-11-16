package com.example.demo.dao;

import com.example.demo.entity.ChucVu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer>{
    
}
