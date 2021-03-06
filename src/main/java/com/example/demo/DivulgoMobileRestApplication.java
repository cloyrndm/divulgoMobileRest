package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
public class DivulgoMobileRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivulgoMobileRestApplication.class, args);
	}
}
