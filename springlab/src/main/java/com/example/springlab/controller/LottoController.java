package com.example.springlab.controller;

import com.example.springlab.domain.LottoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class LottoController {
    @GetMapping("/lotto")
    public String lottoProcess(@RequestParam int lottoNum, Model model) {
        int randomNum = new Random().nextInt(6) + 1;
        System.out.println("전달된 숫자: " + lottoNum + ", 생성된 숫자: " + randomNum);

        String result;
        String imgName;

        if (lottoNum == randomNum) {
            result = "추카추카!!";
            imgName = "sun.png";
        } else {
            result = "아쉽네요.. 다음 기회를!!";
            imgName = "rain.png";
        }

        LottoVO lottoVO = new LottoVO(result, imgName);
        model.addAttribute("lottoVO", lottoVO);

        return "lottoView";
    }
}
