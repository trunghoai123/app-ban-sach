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
@Table(name = "nhaxuatban")
@Getter
@Setter
@ConstructorBinding
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhaXuatBan implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4698299611179707357L;
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
    
}
