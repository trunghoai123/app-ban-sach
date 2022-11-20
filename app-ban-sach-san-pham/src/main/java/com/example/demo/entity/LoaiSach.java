package com.example.demo.entity;

import java.io.Serializable;

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
@Getter
@Setter
@ConstructorBinding
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "loaisach")
public class LoaiSach implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="maLoai")
    private int maLoai;
    
    @Column(name="tenLoai")
    private String tenLoai;
    
	@Override
	public String toString() {
		return "LoaiSach [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}  
    
    
}
