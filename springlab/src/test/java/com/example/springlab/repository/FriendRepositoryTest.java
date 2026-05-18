package com.example.springlab.repository;

import com.example.springlab.entity.Friend;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FriendRepositoryTest {

    @Autowired
    private FriendRepository friendRepository;

    @BeforeEach
    void setUp() {
        // 테스트 시작 전 기초 데이터 준비 (최소 3개 유지 조건 충족을 위해)
        if (friendRepository.count() < 3) {
            friendRepository.save(Friend.builder().fname("둘리").fage(10).build());
            friendRepository.save(Friend.builder().fname("또치").fage(11).build());
            friendRepository.save(Friend.builder().fname("도우너").fage(12).build());
        }
    }

    @Test
    @Order(1)
    // TODO: 입력 테스트
    void testInsert() {
        Friend friend = Friend.builder().fname("고길동").fage(40).build();
        Friend saved = friendRepository.save(friend);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getFname()).isEqualTo("고길동");
    }

    @Test
    @Order(2)
    // TODO: 추출(조회) 테스트
    void testFindAll() {
        List<Friend> list = friendRepository.findAll();
        assertThat(list.size()).isGreaterThanOrEqualTo(3);
    }

    @Test
    @Order(3)
    // TODO: 수정 테스트
    void testUpdate() {
        List<Friend> list = friendRepository.findAll();
        Friend first = list.get(0);
        String newName = first.getFname() + "_수정";
        first.setFname(newName);
        friendRepository.save(first);

        Optional<Friend> updated = friendRepository.findById(first.getId());
        assertThat(updated.get().getFname()).isEqualTo(newName);
    }

    @Test
    @Order(4)
    // TODO: 삭제 테스트
    void testDelete() {
        Friend friend = Friend.builder().fname("삭제대상").fage(0).build();
        Friend saved = friendRepository.save(friend);
        int id = saved.getId();

        friendRepository.deleteById(id);
        Optional<Friend> deleted = friendRepository.findById(id);
        assertThat(deleted).isEmpty();

        // 삭제 후에도 3개 이상 남아 있는지 확인
        assertThat(friendRepository.count()).isGreaterThanOrEqualTo(3);
    }
}
