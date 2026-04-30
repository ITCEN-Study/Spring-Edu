package com.example.springedu;

import com.example.springedu.domain.MyTableDTO;
import mybatis.dao.MyTableMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@SpringBootTest
class MyTableMapperInsertTest {
	@Autowired
	MyTableMapper dao;
	@Test
	@Transactional 	// 메서드를 하나의 트랜잭션(작업 단위)으로 묶어주는 Spring의 선언형 트랜잭션 처리 어노테이션
							// 메서드 안에서 실행되는 여러 DB 작업을 “전부 성공(commit)” 또는 “전부 실패(rollback)”로 처리
	@Rollback(false)
	void insert() {
		MyTableDTO dto;
		for(int i=1; i < 6; i++) {
			dto = new MyTableDTO();
			dto.setMyName("둘리"+i);
			dto.setMyAge(10+i);
			boolean result = dao.insert(dto);
			if(result)
				System.out.println("둘리"+i+" 입력 완료");
		}
	}
}
