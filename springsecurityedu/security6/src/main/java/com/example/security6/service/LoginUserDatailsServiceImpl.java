package com.example.security6.service;
import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security6.entity.Authentication;
import com.example.security6.entity.LoginUser;
import com.example.security6.repository.AuthenticationMapper;

import lombok.RequiredArgsConstructor;

/**
 * 커스텀 인증 서비스
 */
@Service
@RequiredArgsConstructor
public class LoginUserDatailsServiceImpl implements UserDetailsService {
	/** DI */
	private final AuthenticationMapper authenticationMapper;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// 인증 테이블에서 데이터를 가져옴
		Authentication authentication = authenticationMapper.selectByUsername(username);
		// 타겟 데이터가 있으면 UserDetails의 구현 클래스를 반환
		if (authentication != null) {
			return new LoginUser(authentication.getUsername(),
					authentication.getPassword(),
					Collections.emptyList()
			);
		} else {
			throw new UsernameNotFoundException(
					username + " => 사용자명이 존재하지 않습니다.");
		}
	}
}