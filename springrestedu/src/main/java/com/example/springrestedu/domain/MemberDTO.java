package com.example.springrestedu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private String name;
    private String email;
    private String phone;

    @Override
    public String toString() {
        return "MemberDTO 객체 {" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    }
}
