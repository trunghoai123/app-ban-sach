package com.example.se.nhom5.appbansach.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "nhanvien")
@ConstructorBinding
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NhanVien {
    @Id
    @Column(name = "maNV")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNV;
    
    @Column(name = "tenNV")
    private String tenNV;
    
    @Column(name = "sdt")
    private String sdt;
    
    @Column(name = "diaChi")
    private String diaChi;
    
    @Column(name = "maChucVu")
    private int maChucVu;
    
    @Column(name = "UserID")
    private String username; 
    
    
}