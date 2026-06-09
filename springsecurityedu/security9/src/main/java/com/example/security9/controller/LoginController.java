package com.example.security9.controller;

import com.example.security9.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLogin(@ModelAttribute LoginForm form) {
		return "login";
	}
}