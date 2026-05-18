package com.example.springrestedu.domain;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "boardNo")
public class BoardDTO {

	private long boardNo;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;

}
