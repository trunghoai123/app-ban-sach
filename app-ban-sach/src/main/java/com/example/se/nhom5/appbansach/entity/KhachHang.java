package com.example.se.nhom5.appbansach.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "khachhang")
@ConstructorBinding
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KhachHang {
    @Id
    @Column(name = "maKH")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int maKH;
    
    @Column(name = "tenKH")
    private String tenKH;
    
    @Column(name = "sDT")
    private String sdt;
    
    @Column(name = "diaChi")
    private String diaChi;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "userID", referencedColumnName="username")
    private User userID; 
    
    
}
