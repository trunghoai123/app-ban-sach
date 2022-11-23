package com.example.se.nhom5.appbansach.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "authorities")
@ConstructorBinding
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Authorities {
    @Id
    @Column(name = "authority")
    private String authority;
    @Column(name = "username")
    private String username; 
    
}
