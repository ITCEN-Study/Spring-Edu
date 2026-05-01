package com.example.springjpaedu;

import com.example.springjpaedu.entity.Book;
import com.example.springjpaedu.repository.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class JPA_BookRepositoryTest {
    @Autowired
    private BookRepository bookR;

    @BeforeEach
    void pr() {
        System.out.println("=".repeat(80));
    }

    @Test
    @Order(1)
    void one() {
        // TODO: 전체 리스트를 리턴하는 메서드를 호출하고 엔티티 객체들을 표준 출력한다.
        List<Book> list = bookR.findAll();
        list.forEach(System.out::println);
    }

    @Test
    @Order(2)
    void two() {
        // TODO: 가격이 높은 순으로 리스트를 리턴하는 메서드를 호출하고 엔티티 객체들을 표준 출력한다.
        List<Book> list = bookR.findAllByOrderByPriceDesc();
        list.forEach(System.out::println);
    }

    @Test
    @Order(3)
    void three() {
        // TODO: 아규먼트로 20000을 전달하여 20000원 이상의 도서 리스트를 리턴하는 메서드를 호출하고 엔티티 객체들을 표준 출력한다.
        List<Book> list = bookR.findByPriceGreaterThanEqual(20000);
        list.forEach(System.out::println);
    }

    @Test
    @Order(4)
    void four() {
        // TODO: 아규먼트로 10을 전달하여 id 가 10 번인 도서를 추출해 보고 존재하면 해당 엔티티 객체를 출력하고 존재하지 않으면 ***********존재하지 않음!!************ 을 출력한다.
        Optional<Book> book = bookR.findById(10);
        if (book.isPresent()) {
            System.out.println(book.get());
        } else {
            System.out.println("***********존재하지 않음!!************");
        }
    }

    @Test
    @Order(5)
    void five() {
        // TODO: 아규먼트로 “자바”와 “도커”를 전달하여 도서 타이틀에 자바나 도커가 들어간 도서들의 리스트를 리턴하는 메서드를 호출하고 엔티티 객체들을 표준 출력한다.
        List<Book> list = bookR.findByTitleContainsOrTitleContains("자바", "도커");
        list.forEach(System.out::println);
    }

    @Test
    @Order(6)
    void six() {
        // TODO: 분류별 도서가격 평균을 리턴하는 메서드를 호출하고 엔티티 객체들을 표준 출력한다.
        List<Object[]> list = bookR.findAvgPriceByKind();
        for (Object[] row : list) {
            System.out.println(row[0] + " : " + row[1]);
        }
    }

    @Test
    @Order(7)
    void seven() {
        // TODO: 가장 저렴한 도서의 엔티티 객체를 리턴하는 메서드를 호출하고 객체를 표준 출력한다.
        Book book = bookR.findFirstByOrderByPriceAsc();
        System.out.println(book);
    }

    @Test
    @Order(8)
    void eight() {
        // TODO: 전체 도서의 수를 리턴하는 메서드를 호출하고 전체 도서의 수 : X권 을 표준 출력한다.
        long count = bookR.count();
        System.out.println("전체 도서의 수 : " + count + "권");
    }

    @Test
    @Order(9)
    void nine() {
        // TODO: 아규먼트로 ‘b02’ 를 전달하여 전달된 부류에 속하는 도서의 수를 리턴하는 메서드를 호출하고 전 b02 부류의 도서는 X권 을 표준 출력한다.
        long count = bookR.countByKind("b02");
        System.out.println("b02 부류의 도서는 " + count + "권");
    }

    @Test
    @Order(10)
    void ten() {
        // TODO: 아규먼트로 ‘모던’ 을 전달하여 도서 타이들이 모던으로 시작하는 도서들의 리스트를 리턴하는 메서드를 호출하고 엔티티 객체들을 표준 출력한다.
        List<Book> list = bookR.findByTitleStartingWith("모던");
        list.forEach(System.out::println);
    }
}
