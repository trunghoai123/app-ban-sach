package com.example.se.nhom5.appbansach.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="cthoadon")
@ConstructorBinding
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CTHoaDon {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="MaCTHD")
    private int maCTHD;
    
    @OneToMany
    @JoinColumn(name = "maCTHD") // we need to duplicate the physical information
    private List<Sach> sachs;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "maHD", referencedColumnName="maHD")
    private HoaDon maHD;
     
    @Column(name="soLuong")
    private int soLuong;

	@Override
	public String toString() {
		return "CTHoaDon [maCTHD=" + maCTHD + ", maHD=" + maHD + ", soLuong=" + soLuong + "]";
	}  
    
    
}
