package com.example.springrestedu.config;
import com.example.springrestedu.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/home");

        /*
        registry.addInterceptor(인터셉터객체)
                .addPathPatterns("/*")                
                .excludePathPatterns("/sample"); 
        */
    }
}

