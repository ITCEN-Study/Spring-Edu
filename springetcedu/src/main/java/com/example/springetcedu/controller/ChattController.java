package com.example.springetcedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChattController {
	@RequestMapping("/chatstart")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chatting");
		return mv;
	}
}
