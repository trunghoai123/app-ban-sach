package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class AppBanSachApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBanSachApiGatewayApplication.class, args);
	}

}
