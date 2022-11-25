package com.example.demo.dao;

import com.example.demo.entity.NhaXuatBan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan, Integer>{
    @Query(value = "SELECT * FROM nhaxuatban s where s.maNXB = ?1", nativeQuery = true)
    public NhaXuatBan findNhaXuatBanByMaNXB(int maNXB);
    
    @Query(value = "Select s.maSach, s.donGia, s.hinhAnh, s.sLTon, s.tacGia, s.tenSach, s.maLoai, s.maNXB From sach s inner join nhaxuatban nxb "
    		+ "on s.maNXB = nxb.maNXB where nxb.tenNXB like ?1 "
    		, nativeQuery = true)
    public NhaXuatBan findNhaXuatBanByTenNXB(String tenNXB);
    
}
