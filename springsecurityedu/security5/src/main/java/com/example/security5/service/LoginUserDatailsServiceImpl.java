package com.example.security5.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security5.entity.LoginUser;

/**
* UserDetailsService 구현 클래스
*/
@Service
public class LoginUserDatailsServiceImpl implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		if (username.equals("duke")) {
			return new LoginUser("duke",
					"1111",
					Collections.emptyList());
		} else if (username.equals("olaf")) {
			return new LoginUser("olaf",
					"2222",
					Collections.emptyList());
		} else {
			throw new UsernameNotFoundException(
					username + " => 사용자명이 존재하지 않습니다.");
		}
	}
}