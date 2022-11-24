package com.example.se.nhom5.appbansach.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "nhaxuatban")
@Getter
@Setter
@ConstructorBinding
@ToString
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNXB")
    private int maNXB;
    @Column(name = "tenNXB")
    private String tenNXB;
	@Override
	public String toString() {
		return "NhaXuatBan [maNXB=" + maNXB + ", tenNXB=" + tenNXB + "]";
	}
	public int getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(int maNXB) {
		this.maNXB = maNXB;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	public NhaXuatBan() {
		super();
	}
	public NhaXuatBan(int maNXB, String tenNXB) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
	}
	
	
    
}
