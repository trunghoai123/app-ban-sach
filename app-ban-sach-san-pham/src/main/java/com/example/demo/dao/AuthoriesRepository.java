package com.example.demo.dao;

import com.example.demo.entity.Authorities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 


@Repository
public interface AuthoriesRepository extends JpaRepository<Authorities, String>{

}
