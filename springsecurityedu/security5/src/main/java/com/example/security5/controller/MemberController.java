package com.example.security5.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/")
	public String member(@AuthenticationPrincipal User user, Model model) {
		System.out.println(user);
		model.addAttribute("username", user.getUsername());
		return "member";
	}
}