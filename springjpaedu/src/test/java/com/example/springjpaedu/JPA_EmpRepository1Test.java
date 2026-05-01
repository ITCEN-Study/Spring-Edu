package com.example.springjpaedu;

import com.example.springjpaedu.entity.Emp;
import com.example.springjpaedu.repository.EmpRepository1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
// @DataJpaTest를 사용하면 자동으로 EmbededDatabase-H2를 사용하게 된다.
// MySQL과 같이 외부의 DB 를 연결하려는 경우엔 이 어노테이션을 추가로 사용한다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest // JPA 관련 빈만 로딩, Repository 테스트에 최적화, 각테스트마다 rollback 자동 수행

public class JPA_EmpRepository1Test {
    @Autowired
    private EmpRepository1 empR;

    @BeforeEach
    void pr() {
        System.out.println("=".repeat(80));
    }

    @Test
    void list1() {
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
    @Test
    void list2() {
        List<Emp> list = empR.findAll(Sort.by("sal").descending());
        list.stream().forEach(System.out::println);
    }
    @Test
    void list3() {
        List<Emp> list = empR.findAll(Sort.by("sal").ascending());
        list.stream().forEach(System.out::println);
    }
    @Test
    void list4() {
        Page<Emp> list = empR.findAll(PageRequest.of(0, 2));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list5() {
        Page<Emp> list = empR.findAll(PageRequest.of(3, 4));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list6() {
        List<Emp> list = empR.findAll(Sort.by("ename"));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list7() {
        Page<Emp> list = empR.findAll(PageRequest.of(0, 3, Sort.by("ename")));
        list.stream().forEach(System.out::println);
    }
}
