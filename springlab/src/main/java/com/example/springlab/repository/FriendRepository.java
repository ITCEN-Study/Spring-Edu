package com.example.springlab.repository;

import com.example.springlab.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    // TODO: 친구 이름을 입력하면 해당 친구 데이터를 리턴하는 메서드 정의
    List<Friend> findByFname(String fname);
}
