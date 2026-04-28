package com.example.springlab.controller;

import com.example.springlab.domain.StudentDTO;
import mybatis.dao.StudentMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController1 {

    @Autowired
    private StudentMapper1 studentMapper;

    @GetMapping("/test1")
    public String test1(Model model) {
        List<StudentDTO> list = studentMapper.listAll();
        model.addAttribute("list", list);
        model.addAttribute("title", "전체 학생 리스트");
        return "studentView1";
    }

    @GetMapping("/test2")
    public String test2(Model model) {
        List<StudentDTO> list = studentMapper.listOrderByScoreDesc();
        model.addAttribute("list", list);
        model.addAttribute("title", "점수가 높은 순 학생 리스트");
        return "studentView1";
    }

    @GetMapping("/test3")
    public String test3(Model model) {
        List<StudentDTO> list = studentMapper.listByScoreGreaterEqualThan70();
        model.addAttribute("list", list);
        model.addAttribute("title", "점수가 70점 이상인 학생 리스트");
        return "studentView1";
    }

    @GetMapping("/test4")
    public String test4(Model model) {
        List<StudentDTO> list = studentMapper.listByContainName();
        model.addAttribute("list", list);
        model.addAttribute("title", "이름에 '짱'이 들어간 학생 리스트");
        return "studentView1";
    }

    @GetMapping("/test5")
    public String test5(@RequestParam String name, Model model) {
        Integer score = studentMapper.getScore(name);
        model.addAttribute("msg", name + " 학생의 점수는 " + (score != null ? score : "정보없음") + "입니다.");
        model.addAttribute("title", "학생 점수 조회");
        return "studentView1";
    }

    @GetMapping("/test6")
    public String test6(Model model) {
        Double avg = studentMapper.getScoreAvg();
        model.addAttribute("msg", "전체 학생의 점수 평균은 " + (avg != null ? String.format("%.2f", avg) : "0") + "입니다.");
        model.addAttribute("title", "전체 학생 점수 평균");
        return "studentView1";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String name, Model model) {
        try {
            int result = studentMapper.deleteStudent(name);
            if (result > 0) {
                return "redirect:/test1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("deleteFailed", true);
        return "studentView1";
    }

    @PostMapping("/insert")
    public String insert(StudentDTO dto, Model model) {
        try {
            int result = studentMapper.insertStudent(dto);
            if (result > 0) {
                return "redirect:/test1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("insertFailed", true);
        return "studentView1";
    }
}
