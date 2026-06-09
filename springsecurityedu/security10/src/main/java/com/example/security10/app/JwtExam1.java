package com.example.security10.app;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtExam1 {

    // 비밀 키를 Base64 인코딩된 문자열로 관리하는 것이 권장됨
    private static final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret";

    // 키 생성 (Base64로 된 비밀키를 바이트 배열로 변환한 뒤 사용 가능)
    private Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String subject) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 1000 * 60 * 60; // 1시간 만료
        Map<String, Object> claimMap = new HashMap<String, Object>();
        claimMap.put("level", "gold");

        return Jwts.builder()
                .setClaims(claimMap)
                .setSubject(subject)   				// sub 클레임
                .setIssuedAt(new Date(nowMillis))  	// iat 클레임
                .setExpiration(new Date(expMillis))	// exp 클레임               
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)  // 서명
                .compact();
    }

    public static void main(String[] args) {
        JwtExam1 jwtUtil = new JwtExam1();

        String token = jwtUtil.generateToken("unico123");
        System.out.println("생성된 JWT 토큰:");
        System.out.println(token);
    }
}

