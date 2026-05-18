package com.example.springrestedu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8088")
public class HomeController {
	@GetMapping("/home")
	public String corstest() {
		System.out.println("HomeController 수행");
		return "CORS 설정을 하지 않았어요ㅜㅜ";
	}
}
