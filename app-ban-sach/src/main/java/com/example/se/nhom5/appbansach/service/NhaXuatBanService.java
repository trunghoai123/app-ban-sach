package com.example.se.nhom5.appbansach.service;

import java.util.List;

import com.example.se.nhom5.appbansach.entity.NhaXuatBan;

public interface NhaXuatBanService {
    public List<NhaXuatBan> findAll();
    public NhaXuatBan findNhaXuatBanByMaNXB(int maNXB);
    public void deleteNXBById(int maNXB);
}
