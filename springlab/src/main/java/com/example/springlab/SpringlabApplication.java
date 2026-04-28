package com.example.springlab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mybatis.dao")
public class SpringlabApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringlabApplication.class, args);
	}
}
