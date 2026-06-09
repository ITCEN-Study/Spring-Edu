package com.example.security10.app;

public class JwtExam2 {
    public static void main(String[] args) {
        JwtValidator validator = new JwtValidator();
        String token = "JwtExam1에서 만들어진 토큰 내용";
        if (validator.validateToken(token)) {
            System.out.println("JWT 토큰이 유효합니다.");
        } else {
            System.out.println("JWT 토큰이 유효하지 않습니다.");
        }
    }
}

