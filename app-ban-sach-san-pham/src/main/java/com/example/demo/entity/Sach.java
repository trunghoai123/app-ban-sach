package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.context.properties.ConstructorBinding;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Entity
@Table(name = "sach")
@ConstructorBinding
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sach implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2497873727572522258L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="maSach")
    private int maSach;
    
    @Column(name="tenSach")
    private String tenSach;
    
    @Column(name="tacGia")
    private String tacGia ;
    
    @Column(name="sLTon")
    private int soLuongTon ;
    
    @Column(name="donGia")
    private double donGia;
    
    @Column(name="hinhAnh")
    private String hinhAnh;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "maLoai", referencedColumnName="maLoai")
    private LoaiSach maLoai;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "maNXB", referencedColumnName="maNXB")
    private NhaXuatBan maNXB;
    
    @ManyToOne
    @JoinColumn(name = "maCTHD", insertable = false, updatable = false)
    private CTHoaDon cTHoaDon; 

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public LoaiSach getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(LoaiSach maLoai) {
		this.maLoai = maLoai;
	}

	public NhaXuatBan getMaNXB() {
		return maNXB;
	}

	public void setMaNXB(NhaXuatBan maNXB) {
		this.maNXB = maNXB;
	}

	public CTHoaDon getcTHoaDon() {
		return cTHoaDon;
	}

	public void setcTHoaDon(CTHoaDon cTHoaDon) {
		this.cTHoaDon = cTHoaDon;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", soLuongTon=" + soLuongTon
				+ ", donGia=" + donGia + ", hinhAnh=" + hinhAnh + ", maLoai=" + maLoai + ", maNXB=" + maNXB
				+ ", cTHoaDon=" + cTHoaDon + "]";
	}
     
//    public Sach( ) {
//        super(); 
//    }
//    
//    public Sach(int maSach) {
//        super();
//        this.maSach = maSach; 
//    }
//    
//    public Sach(int maSach, String tenSach, String tacGia, double donGia, int soLuongTon, LoaiSach maLoai, NhaXuatBan  maNXB, String hinhAnh) {
//        super();
//        this.maSach = maSach;
//        this.tenSach = tenSach;
//        this.tacGia = tacGia;
//        this.donGia = donGia;
//        this.maLoai = maLoai;
//        this.maNXB = maNXB;
//        this.soLuongTon = soLuongTon;
//        this.hinhAnh = hinhAnh;
//    }
//    
//    public int getSoLuongTon() {
//        return soLuongTon;
//    }
//
//    public void setSoLuongTon(int soLuongTon) {
//        this.soLuongTon = soLuongTon;
//    }
//
//    public String getHinhAnh() {
//        return hinhAnh;
//    }
//
//    public void setHinhAnh(String hinhAnh) {
//        this.hinhAnh = hinhAnh;
//    }
//
//    public int getMaSach() {
//        return maSach;
//    }
//    public void setMaSach(int maSach) {
//        this.maSach = maSach;
//    }
//    public String getTenSach() {
//        return tenSach;
//    }
//    public void setTenSach(String tenSach) {
//        this.tenSach = tenSach;
//    }
//    public String getTacGia() {
//        return tacGia;
//    }
//    public void setTacGia(String tacGia) {
//        this.tacGia = tacGia;
//    }
//    public double getDonGia() {
//        return donGia;
//    }
//    public void setDonGia(double donGia) {
//        this.donGia = donGia;
//    }
//    public LoaiSach getMaLoai() {
//        return maLoai;
//    }
//    public void setLoaiSach(LoaiSach maLoai) {
//        this.maLoai = maLoai;
//    }
//    public NhaXuatBan getMaNXB() {
//        return maNXB;
//    }
//    public void setNhaXuatBan(NhaXuatBan maNXB) {
//        this.maNXB = maNXB;
//    }
//
//   
//    @Override
//    public String toString() {
//        return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", donGia=" + donGia
//                + ", loaiSach=" + maLoai + ", nhaXuatBan=" + maNXB + "]";
//    }
    
}
