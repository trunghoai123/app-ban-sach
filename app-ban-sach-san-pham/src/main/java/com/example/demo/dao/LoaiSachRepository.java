package com.example.demo.dao;

import com.example.demo.entity.LoaiSach;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

@Repository
public interface LoaiSachRepository extends JpaRepository<LoaiSach , Integer>{
    
}   
