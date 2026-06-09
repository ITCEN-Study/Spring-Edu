package com.example.security11.controller;

import com.example.security11.dto.JoinDTO;
import com.example.security11.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinProcess(@ModelAttribute  JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);
        return "ok";
    }
}
