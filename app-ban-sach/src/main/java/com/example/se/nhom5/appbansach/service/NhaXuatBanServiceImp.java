package com.example.se.nhom5.appbansach.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.se.nhom5.appbansach.dao.NhaXuatBanRepository;
import com.example.se.nhom5.appbansach.entity.NhaXuatBan;

@Service
public class NhaXuatBanServiceImp implements NhaXuatBanService{
    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;
    @Override
    @Transactional
    public List<NhaXuatBan> findAll() {
        return nhaXuatBanRepository.findAll();
    }

    @Override
    @Transactional
    public NhaXuatBan findNhaXuatBanByMaNXB(int maNXB) {
        return nhaXuatBanRepository.findNhaXuatBanByMaNXB(maNXB);
    }

    @Override
    @Transactional
    public void deleteNXBById(int maNXB) {
//        nhaXuatBanRepository.deleteNXBById(maNXB);
    }
}
