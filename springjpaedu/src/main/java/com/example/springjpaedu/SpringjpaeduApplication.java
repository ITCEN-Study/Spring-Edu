package com.example.springjpaedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication //(exclude = DataSourceAutoConfiguration.class)
public class SpringjpaeduApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpaeduApplication.class, args);
	}

}
