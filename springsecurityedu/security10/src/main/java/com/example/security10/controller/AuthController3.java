package com.example.security10.controller;

import java.nio.charset.StandardCharsets;

import com.example.security10.service.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Claims;

@RestController
public class AuthController3 {
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/auth3")
    public ResponseEntity<String> extractToken(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Authorization 헤더가 없거나 형식이 올바르지 않습니다.");
        }

        // "Bearer " 접두어 제거 후 실제 JWT 토큰 추출
        String token = authorizationHeader.substring(7);
        String subject = "";
        String content;
        try {
            Claims claims = jwtUtil.parseToken(token);       
            subject = claims.getSubject();
            content = "로그인 확인됩니다.." + subject+"회원님!!";
        } catch (ExpiredJwtException e) {
            content = "전송된 JWT 의 유효시간이 지났습니다. 재로그인 하세요~~~";
        }  catch (Exception e) {
            e.printStackTrace();
            content = "오류가 발생했습니다";
        }

        // 토큰에 대한 추가 검증 로직 또는 활용 로직을 여기에 구현 가능
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));

        return ResponseEntity.ok()
                						 .headers(headers)
                			             .body(content);
    }
}

