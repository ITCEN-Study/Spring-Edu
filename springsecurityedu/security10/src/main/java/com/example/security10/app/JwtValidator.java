package com.example.security10.app;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class JwtValidator {

    private static final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret"; // 256비트 이상의 안전한 키

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                            .setSigningKey(getSigningKey())
                            .build()
                            .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("토큰 만료됨: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("토큰 서명 검증 실패: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("토큰 구조 이상: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("기타 토큰 검증 에러: " + e.getMessage());
        }
        return false;
    }
}

