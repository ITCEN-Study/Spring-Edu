package com.example.springedu;

import com.example.springedu.domain.MyTableDTO;
import mybatis.dao.MyTableMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyTableMapperReadTest {
	@Autowired
	MyTableMapper dao;
	@Test
	void read() {
		dao.list().stream().forEach(System.out::println);
	}
}
