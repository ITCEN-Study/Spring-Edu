package com.example.security10.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RemoveJsessionIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("RemoveJsessionIdFilter 실행");

        chain.doFilter(request, response);

        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("committed = " + res.isCommitted());

        res.setHeader("Set-Cookie",
                "JSESSIONID=; Path=/; Max-Age=0; HttpOnly");
    }
}

