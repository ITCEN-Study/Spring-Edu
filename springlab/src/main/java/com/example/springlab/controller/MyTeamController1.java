package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyTeamController1 {

    @ModelAttribute("myteam")
    public TeamDTO getTeamDTO() {
        return new TeamDTO();
    }

    @GetMapping("/myTeam1")
    public String showMyTeam(String action, @ModelAttribute("myteam") TeamDTO teamDTO) {
        if ("name".equals(action)) {
            teamDTO.setTeamName("2팀");
        } else if ("member".equals(action)) {
            teamDTO.setTeamName("2팀");
            List<TeamMemberVO> members = new ArrayList<>();
            members.add(new TeamMemberVO("정가영", "쩡가", "초밥"));
            members.add(new TeamMemberVO("김윤우", "유누", "곱창"));
            members.add(new TeamMemberVO("이재혁", "재혁", "모든 것"));
            members.add(new TeamMemberVO("안주현", "안주", "햄버거"));
            teamDTO.setTeamMember(members);
        }
        return "myTeamView";
    }
}
