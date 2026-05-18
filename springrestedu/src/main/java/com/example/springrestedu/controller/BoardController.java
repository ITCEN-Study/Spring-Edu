package com.example.springrestedu.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.example.springrestedu.domain.BoardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
//@CrossOrigin(origins = "http://127.0.0.1:8088")
@CrossOrigin(origins = "*")
public class BoardController {

	List<BoardDTO> boardList = new ArrayList<>();

	public BoardController() {
		BoardDTO board = new BoardDTO();
		board.setBoardNo(1);
		board.setTitle("아기공룡 둘리 한자대탐험");
		board.setContent("둘리 학습만화 시리즈");
		board.setWriter("김수정");
		board.setRegDate(LocalDateTime.now());

		boardList.add(board);

		board = new BoardDTO();
		board.setBoardNo(2);
		board.setTitle("고래 도서관");
		board.setContent("바다 도서관 이야기");
		board.setWriter("지드루");
		board.setRegDate(LocalDateTime.now());
		boardList.add(board);
	}

	@GetMapping
	public ResponseEntity<List<BoardDTO>> list() {
		log.info("list 요청");
		if(boardList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		ResponseEntity<List<BoardDTO>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);
		return entity;
	}

	@PostMapping
	public ResponseEntity<String> register(@RequestBody BoardDTO board) {
		log.info("register 요청");
		boardList.add(board);
		ResponseEntity<String> entity = new ResponseEntity<>("성공적으로 삽입했어용", HttpStatus.CREATED);

		return entity;
	}

	@GetMapping("/{boardNo}")
	public ResponseEntity<BoardDTO> read(@PathVariable("boardNo") int boardNo) {
		log.info("read 요청");

		BoardDTO board = new BoardDTO();
		board.setBoardNo(boardNo);
	 	int index = boardList.indexOf(board);
		if (index >= 0)
			 board = boardList.get(index);

		ResponseEntity<BoardDTO> entity = new ResponseEntity<>(board, HttpStatus.OK);

		return entity;
	}

	@DeleteMapping("/{boardNo}")
	public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo) {
		log.info("remove 요청");
		BoardDTO board = new BoardDTO();
		board.setBoardNo(boardNo);
		boardList.remove(board);

		ResponseEntity<String> entity = new ResponseEntity<>("성공적으로 삭제했어용", HttpStatus.OK);

		return entity;
	}

	@PutMapping("/{boardNo}")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody BoardDTO board) {
		log.info("modify 요청");
		BoardDTO board1 = new BoardDTO();
		board1.setBoardNo(boardNo);
		int index = boardList.indexOf(board1);
		if (index >= 0)
			board1 = boardList.get(index);
		board1.setWriter(board.getWriter());
		board1.setContent(board.getContent());
		board1.setTitle(board.getTitle());
		board1.setRegDate(board.getRegDate());

		ResponseEntity<String> entity =
				new ResponseEntity<>("성공적으로 수정했어용", HttpStatus.OK);
		return entity;
	}

	@GetMapping("/day")
	public String day() {
		LocalDate ld = LocalDate.now();
		DayOfWeek dow = ld.getDayOfWeek();
		String korDay = dow.getDisplayName(TextStyle.SHORT, Locale.KOREAN);
		return korDay;
	}

	@GetMapping(value = "/friends")
	public String getFriends() {
		log.info("getFriends 메소드가 호출되었습니다.");
		return "둘리 또치 도우너";
	}
}
