package com.example.springedu.controller;
import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogTestController1 {
	private static final Logger log = LoggerFactory.getLogger(LogTestController1.class);
	@RequestMapping("/log1")
	public ModelAndView xxx(HttpServletRequest req){
		log.error("error-로그를 테스트합니다!");
		log.warn("warn-로그를 테스트합니다!");
		log.info("info-로그를 테스트합니다!");
		log.debug("debug-로그를 테스트합니다!");
		log.trace("trace-로그를 테스트합니다!");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("logView");
		mav.addObject("msg", "톰캣콘솔창에서 확인하세요!!");
		return mav;
	}
}




