package com.example.demo.dao;

import com.example.demo.entity.HoaDon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

}
