package com.example.se.nhom5.appbansach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppBanSachApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBanSachApplication.class, args);
	}

}
