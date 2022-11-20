package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "users")
@ConstructorBinding
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -782632619283920341L;
	@Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private int enabled; 
    
    
}
