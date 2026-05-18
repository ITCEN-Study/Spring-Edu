package com.example.security6.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.security6.entity.Authentication;

@Mapper
public interface AuthenticationMapper {
	
	/**
	* 사용자명으로 로그인 정보를 조회
	*/
	@Select("SELECT username, password FROM authentications WHERE username =#{username}")
	Authentication selectByUsername(String username);
}