package com.example.springrestedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringresteduApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringresteduApplication.class, args);
	}

}
