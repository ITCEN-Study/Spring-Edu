package com.example.springlab.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamMemberVO {
    private String name;
    private String nicName;
    private String food;
}
