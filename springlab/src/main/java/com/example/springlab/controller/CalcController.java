package com.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalcController {

    @RequestMapping("/calc")
    public String calculate(int num1, int num2, String operator, Model model) {
        int result = 0;

        if (operator.equals("div") && num2 == 0) {
            model.addAttribute("errorMsg", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!");
            return "errorResult";
        }

        switch (operator) {
            case "plus": result = num1 + num2; break;
            case "minus": result = num1 - num2; break;
            case "times": result = num1 * num2; break;
            case "div": result = num1 / num2; break;
        }

        model.addAttribute("result", result);
        return "calcResult";
    }
}