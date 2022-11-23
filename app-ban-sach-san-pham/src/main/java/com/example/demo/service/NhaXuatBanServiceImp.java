package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.dao.NhaXuatBanRepository;
import com.example.demo.entity.NhaXuatBan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

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

	@Override
	public NhaXuatBan findNhaXuatBanByTenNXB(String tenNXB) {
		 return nhaXuatBanRepository.findNhaXuatBanByTenNXB(tenNXB);
	}
}
