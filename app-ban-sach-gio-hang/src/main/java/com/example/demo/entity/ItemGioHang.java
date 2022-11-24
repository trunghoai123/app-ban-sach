package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@AllArgsConstructor 
@ConstructorBinding
@ToString
@Getter
@Setter
@Data
public class ItemGioHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5579504342314349790L;
	private Integer id;
	private String productName;
	private double price;
	private int quantity;
	
	
}
