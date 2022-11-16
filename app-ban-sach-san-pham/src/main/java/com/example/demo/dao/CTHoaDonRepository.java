package com.example.demo.dao;

import com.example.demo.entity.CTHoaDon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

@Repository
public interface CTHoaDonRepository extends JpaRepository<CTHoaDon, Integer>{

}
