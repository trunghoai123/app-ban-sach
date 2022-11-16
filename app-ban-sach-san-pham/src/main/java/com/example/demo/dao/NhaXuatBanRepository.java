package com.example.demo.dao;

import com.example.demo.entity.NhaXuatBan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan, Integer>{
    @Query(value = "SELECT * FROM nhaxuatban s where s.maNXB = ?1", nativeQuery = true)
    public NhaXuatBan findNhaXuatBanByMaNXB(int maNXB);
}
