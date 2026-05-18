package com.example.springlab.controller;

import com.example.springlab.entity.Friend;
import com.example.springlab.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
/* TODO: 외부 프로젝트(edu)에서의 접근을 허용하기 위해 CORS 설정을 추가한다. */
@CrossOrigin
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    // TODO: 친구 데이터의 전체 리스트를 JSON 형식으로 리턴하는 메서드를 구현한다.
    // 내용이 없다면 응답 코드 204를 반환한다.
    @GetMapping
    public ResponseEntity<List<Friend>> list() {
        log.info("list 요청");
        List<Friend> list = friendRepository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    // TODO: 클라이언트에서 전달된 ID 를 가지고 해당 친구 데이터를 JSON 형식으로 리턴하는 메서드를 구현한다.
    // 존재하지 않으면 400 에러와 함께 BAD_ID 헤더를 추가한다.
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable("id") int id) {
        log.info("read 요청: id={}", id);
        Optional<Friend> friend = friendRepository.findById(id);
        if (friend.isPresent()) {
            return ResponseEntity.ok(friend.get());
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("BAD_ID", String.valueOf(id));
            return new ResponseEntity<>("존재하지 않는 친구입니다.", headers, HttpStatus.BAD_REQUEST);
        }
    }

    // TODO: 친구 이름을 입력하면 해당 친구 데이터를 JSON 형식으로 리턴하는 메서드를 구현한다.
    @GetMapping("/name/{fname}")
    public ResponseEntity<List<Friend>> readByName(@PathVariable("fname") String fname) {
        log.info("readByName 요청: fname={}", fname);
        List<Friend> list = friendRepository.findByFname(fname);
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    // TODO: 클라이언트에서 JSON 형식으로 전달된 데이터를 Friend 테이블에 저장하는 메서드를 구현한다.
    // 성공하면 201, 실패하면 500을 반환한다.
    @PostMapping
    public ResponseEntity<String> register(@RequestBody Friend friend) {
        log.info("register 요청: {}", friend);
        try {
            friendRepository.save(friend);
            return new ResponseEntity<>("성공적으로 삽입했어요", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("register 오류", e);
            return new ResponseEntity<>("실패했음.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO: 클라이언트에서 JSON 형식으로 전달된 데이터를 Friend 테이블에 수정하는 메서드를 구현한다.
    // 성공하면 205, 실패하면 500을 반환한다.
    @PutMapping
    public ResponseEntity<String> modify(@RequestBody Friend friend) {
        log.info("modify 요청: {}", friend);
        try {
            // ID가 반드시 있어야 함
            if (friend.getId() == null || !friendRepository.existsById(friend.getId())) {
                return new ResponseEntity<>("실패했다는 메시지 (ID 존재하지 않음)", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            friendRepository.save(friend);
            return new ResponseEntity<>("성공적으로 수정했어용", HttpStatus.RESET_CONTENT);
        } catch (Exception e) {
            log.error("modify 오류", e);
            return new ResponseEntity<>("실패했다는 메시지", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO: 클라이언트에서 전달된 ID 를 가지고 데이터를 삭제하는 메서드를 구현한다.
    // 성공하면 205, 실패하면 500을 반환한다.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable("id") int id) {
        log.info("remove 요청: id={}", id);
        try {
            if (!friendRepository.existsById(id)) {
                return new ResponseEntity<>("실패했다는 메시지 (ID 존재하지 않음)", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            friendRepository.deleteById(id);
            return new ResponseEntity<>("성공적으로 삭제했어용", HttpStatus.RESET_CONTENT);
        } catch (Exception e) {
            log.error("remove 오류", e);
            return new ResponseEntity<>("실패했다는 메시지", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
