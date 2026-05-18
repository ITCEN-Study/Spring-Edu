package com.example.security8;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.security8.repository"})
public class Security8Application {

	public static void main(String[] args) {
		SpringApplication.run(Security8Application.class, args);
	}

}
