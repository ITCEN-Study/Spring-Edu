package com.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudyPathController {

    @GetMapping("/study/{num}/thymeleaf")
    public String redirectStudy(@PathVariable int num) {
        String targetUrl = "";
        switch (num) {
            case 1:
                targetUrl = "https://abbo.tistory.com/56";
                break;
            case 2:
                targetUrl = "https://abbo.tistory.com/57";
                break;
            case 3:
                targetUrl = "https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html";
                break;
            case 4:
                targetUrl = "https://www.baeldung.com/dates-in-thymeleaf";
                break;
            default:
                return "redirect:/"; 
        }
        return "redirect:" + targetUrl;
    }
}
