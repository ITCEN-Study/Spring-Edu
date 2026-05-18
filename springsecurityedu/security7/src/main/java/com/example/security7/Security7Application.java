package com.example.security7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.security7.repository"})
public class Security7Application {

	public static void main(String[] args) {
		SpringApplication.run(Security7Application.class, args);
	}

}
