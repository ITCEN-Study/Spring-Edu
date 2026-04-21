package com.example.springedu.controller;

import com.example.springedu.domain.LottoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class LottoController {

    @GetMapping("/lotto")
    public String lottoProcess(int lottoNum, Model model) {
        int randomNum = new Random().nextInt(6) + 1;
        System.out.println("전달된 숫자: " + lottoNum + ", 생성된 숫자: " + randomNum);

        LottoVO lottoVO = new LottoVO();
        if (lottoNum == randomNum) {
            lottoVO.setMsg("추카추카!!");
            lottoVO.setImgPath("/images/sun.png");
        } else {
            lottoVO.setMsg("아쉽네요 .. 다음 기회를!!");
            lottoVO.setImgPath("/images/rain.png");
        }
        
        model.addAttribute("lottoVO", lottoVO);
        return "lottoView";
    }
}
