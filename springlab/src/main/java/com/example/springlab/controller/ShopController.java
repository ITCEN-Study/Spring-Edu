package com.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShopController {

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("view", "product");
        return "product";
    }

    @GetMapping("/basket")
    public String basket(@RequestParam(required = false) String pid, HttpSession session, Model model) {
        if (pid != null && pid.equals("clear")) {
            session.removeAttribute("basket");
            model.addAttribute("view", "basket");
            return "product";
        }

        Map<String, Integer> basket = (Map<String, Integer>) session.getAttribute("basket");
        if (basket == null) {
            basket = new HashMap<>();
            session.setAttribute("basket", basket);
        }

        if (pid != null) {
            basket.put(pid, basket.getOrDefault(pid, 0) + 1);
        }

        model.addAttribute("basket", basket);
        model.addAttribute("view", "basket");
        return "product";
    }
}
