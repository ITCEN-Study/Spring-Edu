package com.example.springlab.controller;

import com.example.springlab.domain.TeamDTO;
import com.example.springlab.domain.TeamMemberVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyTeamController2 {

    @GetMapping("/myTeam2")
    public TeamDTO getTeamJson() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("짱짱티센");

        List<TeamMemberVO> members = new ArrayList<>();
        members.add(new TeamMemberVO("이재혁", "재혁", "야채곱창"));
        members.add(new TeamMemberVO("이충헌", "충맨", "삼겹살"));
        members.add(new TeamMemberVO("정가영", "쩡가", "초밥"));
        members.add(new TeamMemberVO("남지호", "집순이", "불고기"));
        
        teamDTO.setTeamMember(members);
        return teamDTO;
    }
}
