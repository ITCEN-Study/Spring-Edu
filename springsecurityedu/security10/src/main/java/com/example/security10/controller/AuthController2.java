package com.example.security10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.security10.dto.AuthenticationDTO;
import com.example.security10.service.JwtUtil;

@RestController
public class AuthController2 {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth2")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationDTO authDto) {
        // 실제 환경이라면 사용자 인증(비밀번호 확인 등) 추가 필요
        String jwt = jwtUtil.generateToken(authDto.getUsername());
        System.out.println("authDto : " + authDto);

        // JWT 토큰을 Authorization 헤더에 넣기 (Bearer prefix)
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwt);
        System.out.println(jwt);

        return ResponseEntity.ok().headers(headers).build();
    }
}


