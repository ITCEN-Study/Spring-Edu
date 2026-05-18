package com.example.springrestedu.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/*"})
public class TestFilter1 implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();
        // 시스템성/도구용 요청은 로그를 남기지 않고 바로 다음 필터로 토스
        if (path.startsWith("/.well-known") || path.equals("/favicon.ico")) {
            chain.doFilter(request, response);
            return;
        }
        log.info("[필터1] 요청 자원 수행 전");
        chain.doFilter(request, response);
        log.info("[필터1] 요청 자원 수행 후");
    }
}
