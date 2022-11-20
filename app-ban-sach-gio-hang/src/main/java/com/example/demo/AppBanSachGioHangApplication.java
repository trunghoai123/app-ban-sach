package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableAutoConfiguration
@RequiredArgsConstructor
@EnableEurekaClient
public class AppBanSachGioHangApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBanSachGioHangApplication.class, args);
	}

}
