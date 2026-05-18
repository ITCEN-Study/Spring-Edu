package com.example.security5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security5.form.LoginForm;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLogin(@ModelAttribute LoginForm form) {
		return "login";
	}
}