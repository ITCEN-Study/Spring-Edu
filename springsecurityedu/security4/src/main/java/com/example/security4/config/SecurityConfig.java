package com.example.security4.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			// ★ HTTP 요청에 대한 보안 설정
			.authorizeHttpRequests(requests -> requests
					// /login은 인증이 필요하지 않음
					.requestMatchers("/login").permitAll()
					// 그 밖의 요청은 인증이 필요
					.anyRequest().authenticated())
		    // 사이트 간 요청 위조(CSRF) 방어 기능을 비활성화. 주로 API 서버를 구축하거나, 테스트 환경에서 편의를 위해 끄는 거임.
			.csrf((csrf) -> csrf.disable())
			// ★ 폼 기반 로그인 설정
			.formLogin(form -> form
					// 커스텀 로그인 페이지 URL 지정
					.loginPage("/login")
					// 로그인 처리 URL 지정
					.loginProcessingUrl("/authentication")
					// 사용자명의 name 속성 지정
					.usernameParameter("usernameInput")
					// 비밀번호의 name 속성 지정
					.passwordParameter("passwordInput")
					// 로그인 성공 시 리디렉션할 URL 지정
					.defaultSuccessUrl("/", true)
					// 로그인 실패 시 리디렉션할 URL 지정
					.failureUrl("/login?error"))
			// ★로그아웃 설정
			.logout(logout -> logout
					// 로그아웃을 처리할 URL을 지정
					.logoutUrl("/logout")
					// 로그아웃 성공 시 리디렉션할 목적지를 지정
					.logoutSuccessUrl("/login?logout")
					// 로그아웃 시 세션을 무효화
					.invalidateHttpSession(true)
					// 로그아웃 시 쿠키를 삭제
					.deleteCookies("JSESSIONID")
		   );
		return http.build();
	}
}