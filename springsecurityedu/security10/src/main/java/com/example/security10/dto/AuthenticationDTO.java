package com.example.security10.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticationDTO {
    private String username;
    private String password;  
}

