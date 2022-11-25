package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.NhaXuatBan;
import com.example.demo.entity.Sach;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {
	//sort asc 
	// tên sách, mã loại
	@Query(value = "SELECT * FROM sach s where s.tenSach like %?1% and s.maLoai like ?2 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByTenVaLoaiASC(String tenSach, int maLoai);
	// lọc theo giá(có 2 mức giá và 1 mức giá) và mã loại
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 and s.maLoai like ?3 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaVaLoaiASC(double giaTu, double giaDen, int maLoai);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.maLoai like ?2 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuVaLoaiASC(double giaTu, int maLoai);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 and s.maLoai like ?2 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenVaLoaiASC( double giaDen, int maLoai);
	// mã loại và tên
	@Query(value = "SELECT * FROM sach s where s.maLoai like ?1 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByLoaiASC(int maLoai);
	// giá, loại, tên
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 and s.maLoai like ?3 and s.tenSach like %?4% ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaVaLoaiVaTenASC(double giaTu, double giaDen, int maLoai, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.maLoai like ?2 and s.tenSach like %?3% ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuVaLoaiVaTenASC(double giaTu, int maLoai, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 and s.maLoai like ?2 and s.tenSach like %?3% ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenVaLoaiVaTenASC( double giaDen, int maLoai, String tenSach);
	// lọc k theo loại
	// tên sách
	@Query(value = "SELECT * FROM sach s where s.tenSach like %?1% ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByTenASC(String tenSach);
	// lọc theo giá(có 2 mức giá và 1 mức giá) và mã loại
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaASC(double giaTu, double giaDen);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuASC(double giaTu);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenASC(double giaDen);
	// giá, tên
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 and s.tenSach like %?3% ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaVaTenASC(double giaTu, double giaDen, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.tenSach like %?2% ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuVaTenASC(double giaTu, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 and s.tenSach like %?2% ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenVaTenASC( double giaDen, String tenSach);
	
	
	
	
	//sort desc DESC
	// lọc theo tên sách và mã loại
//	@Query(value = "SELECT * FROM sach s where s.tenSach like %?1% and s.maLoai like ?2 ORDER BY tenSach DESC", nativeQuery = true)
//	public List<Sach> getSachsByTenVaLoaiDESC(String tenSach, int maLoai);
//	// lọc theo giá(có 2 mức giá và 1 mức giá) và mã loại
//	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 and s.maLoai like ?3 ORDER BY tenSach DESC", nativeQuery = true)
//	public List<Sach> getSachsByKhoangGiaVaLoaiDESC(double giaTu, double giaDen, int maLoai);
//	
//	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.maLoai like ?2 ORDER BY tenSach DESC", nativeQuery = true)
//	public List<Sach> getSachsByKhoangGiaTuVaLoaiDESC(double giaTu, int maLoai);
//	
//	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 and s.maLoai like ?2 ORDER BY tenSach DESC", nativeQuery = true)
//	public List<Sach> getSachsByKhoangGiaDenVaLoaiDESC( double giaDen, int maLoai);
//
//	@Query(value = "SELECT * FROM sach s where s.maLoai like ?1 ORDER BY tenSach DESC", nativeQuery = true)
//	public List<Sach> getSachsByLoaiDESC(int maLoai);
	
	// tên sách, mã loại
	@Query(value = "SELECT * FROM sach s where s.tenSach like %?1% and s.maLoai like ?2 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByTenVaLoaiDESC(String tenSach, int maLoai);
	// lọc theo giá(có 2 mức giá và 1 mức giá) và mã loại
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 and s.maLoai like ?3 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaVaLoaiDESC(double giaTu, double giaDen, int maLoai);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.maLoai like ?2 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuVaLoaiDESC(double giaTu, int maLoai);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 and s.maLoai like ?2 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenVaLoaiDESC( double giaDen, int maLoai);
	// mã loại và tên
	@Query(value = "SELECT * FROM sach s where s.maLoai like ?1 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByLoaiDESC(int maLoai);
	// giá, loại, tên
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 and s.maLoai like ?3 and s.tenSach like %?4% ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaVaLoaiVaTenDESC(double giaTu, double giaDen, int maLoai, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.maLoai like ?2 and s.tenSach like %?3% ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuVaLoaiVaTenDESC(double giaTu, int maLoai, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 and s.maLoai like ?2 and s.tenSach like %?3% ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenVaLoaiVaTenDESC( double giaDen, int maLoai, String tenSach);
	// lọc k theo loại
	// tên sách
	@Query(value = "SELECT * FROM sach s where s.tenSach like %?1% ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByTenDESC(String tenSach);
	// lọc theo giá(có 2 mức giá và 1 mức giá) và mã loại
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDESC(double giaTu, double giaDen);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuDESC(double giaTu);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenDESC(double giaDen);
	// giá, tên
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.donGia < ?2 and s.maLoai like ?3 and s.tenSach like %?4% ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaVaTenDESC(double giaTu, double giaDen, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 and s.tenSach like %?2% ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaTuVaTenDESC(double giaTu, String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.donGia < ?1 and s.tenSach like %?2% ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByKhoangGiaDenVaTenDESC( double giaDen, String tenSach);
	
	
	
	//getAll Book by maNXB
	@Query(value = "Select * from sach s where s.maNXB=?1", nativeQuery = true)
	public List<Sach> getSachsByNXB(int maNXB);
	
	//getAll Book by tenNXB
    @Query(value = "Select * From sach s inner join nhaxuatban nxb "
    		+ "on s.maNXB = nxb.maNXB where nxb.tenNXB like ?1 "
    		, nativeQuery = true)
    public List<Sach> findSachByTenNXB(String tenNXB);
	
	
	//----------
	@Query(value = "SELECT * FROM sach s where s.tenSach like %?1%", nativeQuery = true)
	public List<Sach> getSachsByTenSach(String tenSach);
	
	@Query(value = "SELECT * FROM sach s where s.maSach = ?1", nativeQuery = true)
	public Sach getSachByMaSach(int maSach);

	@Query(value = "SELECT * FROM sach s where s.donGia > ?1 AND s.donGia < ?2", nativeQuery = true)
	public List<Sach> getSachByKhoanGia(double giaMin, double giaMax);

	@Query(value = "SELECT * FROM sach ORDER BY tenSach DESC", nativeQuery = true)
	public List<Sach> getSachsByNameASC();

	@Query(value = "SELECT * FROM sach ORDER BY tenSach ASC", nativeQuery = true)
	public List<Sach> getSachsByNameDESC();

	@Query(value = "Select s.maSach, s.donGia, s.hinhAnh, s.sLTon, s.tacGia, s.tenSach, s.maLoai, s.maNXB, s.maCTHD From sach s inner join loaisach ls on s.maLoai = ls.maLoai\r\n"
			+ "where ls.tenLoai like ?1", nativeQuery = true)
	public List<Sach> getSachsByTenLoaiSach(String tenLoai);

//    @Query(value = "Select s.maSach, s.donGia, s.hinhAnh, s.sLTon, s.tacGia, s.tenSach, s.maLoai, s.maNXB, s.maCTHD From sach s inner join loaisach ls on s.maLoai = ls.maLoai\r\n" + 
//            "where ls.tenLoai like  ?1 AND s.donGia > ?1 AND s.donGia < ?2", nativeQuery = true)
//	public List<Sach> findByTenSachAndDonGiaBetween(String tenLoai, double start, double end);
//
//	public List<Sach> findByTenSachAndOrderByTenSachASC(String tenLoai);
//
//	public List<Sach> findByTenSachAndOrderByTenSachDESC(String tenLoai);
//
//	public List<Sach> findByDonGiaBetweenAndOrderByTenSachASC(double start, double end);
//
//	public List<Sach> findByDonGiaBetweenAndOrderByTenSachDESC(double start, double end);
//
//	public List<Sach> findByTenSachAndDonGiaBetweenAndOrderByTenSachASC(String tenLoai, double start, double end);
//
//	public List<Sach> findByTenSachAndDonGiaBetweenAndOrderByTenSachDESC(String tenLoai, double start, double end);

}
