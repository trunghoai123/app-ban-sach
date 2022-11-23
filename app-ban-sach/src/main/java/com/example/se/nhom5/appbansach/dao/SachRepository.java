package com.example.se.nhom5.appbansach.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.se.nhom5.appbansach.entity.Sach;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer>{
    @Query(value = "SELECT * FROM sach s where s.maSach = ?1", nativeQuery = true)
    public Sach getSachByMaSach(int maSach);
    @Query(value = "SELECT * FROM sach s where s.donGia > ?1 AND s.donGia < ?2", nativeQuery = true)
    public List<Sach> getSachByKhoanGia(double giaMin, double giaMax);
    @Query(value = "SELECT * FROM sach ORDER BY tenSach DESC", nativeQuery = true)
    public List<Sach> getSachsByNameASC();
    @Query(value = "SELECT * FROM sach ORDER BY tenSach ASC", nativeQuery = true)
    public List<Sach> getSachsByNameDESC();
    @Query(value = "Select s.maSach, s.donGia, s.hinhAnh, s.sLTon, s.tacGia, s.tenSach, s.maLoai, s.maNXB From sach s inner join loaisach ls on s.maLoai = ls.maLoai\r\n" + 
            "where ls.tenLoai like ?1", nativeQuery = true)
    public List<Sach> getSachsByTenLoaiSach(String tenLoai);
}
