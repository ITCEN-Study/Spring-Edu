package com.example.security10.controller;

import com.example.security10.dto.AuthenticationDTO;
import com.example.security10.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController1 {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth1")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationDTO authRequest) {
        // 실제 환경에서는 user 검증 로직 필요 (DB 조회, 패스워드 비교 등)
        // 여기서는 단순히 username을 기반으로 JWT 생성
        String jwt = jwtUtil.generateToken(authRequest.getUsername());

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    // JWT 응답 DTO
    static class JwtResponse {
        private String token;
        public JwtResponse(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }
    }
}
