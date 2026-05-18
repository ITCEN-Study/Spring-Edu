package com.example.springlab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@MapperScan("mybatis.dao")
@EntityScan("com.example.springlab.entity")
@EnableJpaRepositories("com.example.springlab.repository")
public class SpringlabApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringlabApplication.class, args);
	}
}
