package com.example.demo.dao;

import com.example.demo.entity.KhachHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>{

}
