package com.example.springlab.controller;

import com.example.springlab.domain.LottoVO2;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class LottoController2 {
    @GetMapping("/lotto2")
    public String lottoProcess(@RequestParam(required = false, defaultValue = "0") int lottoNum, Model model, HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        int count = (int) session.getAttribute("count");

        if (count >= 3) {
            LottoVO2 lottoVO = new LottoVO2("로또 응모는 낙첨된 경우에 한하여 3번 까지만 가능합니다.<br>브라우저를 재기동한 후에 응모해 주세요", "snow.png");
            model.addAttribute("lottoVO", lottoVO);
            return "lottoView2";
        }

        int randomNum = new Random().nextInt(6) + 1;
        System.out.println("전달된 숫자: " + lottoNum + ", 생성된 숫자: " + randomNum + ", 현재 시도 횟수: " + (count + 1));

        String result;
        String imgName;

        if (lottoNum == randomNum) {
            result = "추카추카!!";
            imgName = "sun.png";
            session.setAttribute("count", 3);
        } else {
            result = "아쉽네요.. 다음 기회를!!";
            imgName = "rain.png";
            session.setAttribute("count", ++count);
        }

        LottoVO2 lottoVO = new LottoVO2(result, imgName);
        model.addAttribute("lottoVO", lottoVO);

        return "lottoView2";
    }
}
