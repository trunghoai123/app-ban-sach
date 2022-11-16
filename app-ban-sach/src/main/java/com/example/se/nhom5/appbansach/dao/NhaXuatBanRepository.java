package com.example.se.nhom5.appbansach.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.se.nhom5.appbansach.entity.NhaXuatBan;
@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan, Integer>{
    @Query(value = "SELECT * FROM nhaxuatban s where s.maNXB = ?1", nativeQuery = true)
    public NhaXuatBan findNhaXuatBanByMaNXB(int maNXB);
}
