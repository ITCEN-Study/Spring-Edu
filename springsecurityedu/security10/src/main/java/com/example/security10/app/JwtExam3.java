package com.example.security10.app;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtExam3 {

    private static final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret";
    private static final long ACCESS_TOKEN_VALIDITY = 1000 * 60 * 30;  // 30분 -  토큰발행 초시간 + 1800초
    private static final long REFRESH_TOKEN_VALIDITY = 1000 * 60 * 60 * 24 * 7;  // 7일

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    // 액세스 토큰 생성
    public String createAccessToken(String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + ACCESS_TOKEN_VALIDITY);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 리프레시 토큰 생성
    public String createRefreshToken(String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + REFRESH_TOKEN_VALIDITY);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 액세스 + 리프레시 토큰 발급 예시
    public TokenPair generateTokenPair(String subject) {
        String accessToken = createAccessToken(subject);
        String refreshToken = createRefreshToken(subject);
        return new TokenPair(accessToken, refreshToken);
    }

    // 토큰을 담는 DTO 클래스를 별도로 정의
    public static class TokenPair {
        private final String accessToken;
        private final String refreshToken;
        public TokenPair(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
        public String getAccessToken() {
            return accessToken;
        }
        public String getRefreshToken() {
            return refreshToken;
        }
    }

    public static void main(String[] args) {
        JwtExam3 provider = new JwtExam3();

        TokenPair tokens = provider.generateTokenPair("unico@example.com");

        System.out.println("엑세스 토큰: " + tokens.getAccessToken());
        System.out.println("리프레쉬 토큰: " + tokens.getRefreshToken());
    }
}

