package com.example.se.nhom5.appbansach.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "hoadon")
@ToString
@Getter
@Setter
@ConstructorBinding
@NoArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maHD")
    private int maHD;
    @Column(name = "ngayLapHD")
    private Date ngayLapHD;
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", referencedColumnName="username")
    private User userID;
    @Column(name = "tongTien")
    private double tongTien; 
    
}
