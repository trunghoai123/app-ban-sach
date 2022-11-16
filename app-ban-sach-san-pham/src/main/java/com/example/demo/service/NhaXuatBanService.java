package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.NhaXuatBan;
 

public interface NhaXuatBanService {
    public List<NhaXuatBan> findAll();
    public NhaXuatBan findNhaXuatBanByMaNXB(int maNXB);
    public void deleteNXBById(int maNXB);
}
