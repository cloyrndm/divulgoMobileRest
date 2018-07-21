package com.example.demo;

import com.example.demo.Property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class DivulgoMobileRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivulgoMobileRestApplication.class, args);
	}
}
