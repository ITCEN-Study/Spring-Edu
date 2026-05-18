package com.example.security6.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MamberController {
	
	@GetMapping("/")
	public String member(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("username", user.getUsername());
		return "member";
	}
}