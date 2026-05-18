package com.example.security8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/")
	public String menu() {
		return "menu";
	}
	@GetMapping("/todos")
	public String todos() {
		return "todo/list";
	}
}