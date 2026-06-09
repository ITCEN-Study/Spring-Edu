package com.example.security9.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncryptionExample {
    public static void main(String[] args) {
        // 원본 비밀번호
        String rawPassword = "unico123";

        // BCryptPasswordEncoder 객체 생성
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("암호화된 비밀번호: " + encodedPassword);

        // 암호 일치 여부 확인
        boolean isMatch = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("비밀번호 일치 여부: " + isMatch);

        // 잘못된 비밀번호 체크
        String wrongPassword = "unico999";
        boolean wrongMatch = passwordEncoder.matches(wrongPassword, encodedPassword);
        System.out.println("잘못된 비밀번호 일치 여부: " + wrongMatch);
    }
}


