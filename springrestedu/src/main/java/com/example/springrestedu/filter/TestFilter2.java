package com.example.springrestedu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/home"})
public class TestFilter2 implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws IOException, ServletException {
        log.info("[필터2] 요청 자원 수행 전");
        chain.doFilter(request, response);
        log.info("[필터2] 요청 자원 수행 후");
    }
}
