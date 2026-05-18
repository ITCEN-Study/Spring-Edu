package com.example.springnews.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // TODO: id - int -> pk 이며 auto increment
    private int id;

    // TODO: writer - String
    private String writer;
    
    // TODO: title - String
    private String title;

    @Column(columnDefinition = "TEXT")
    // TODO: content - String
    private String content;

    @CreationTimestamp
    // TODO: writedate - LocalDateTime -> 글 작성 시간으로 자동 설정되도록 애노테이션 설정
    private LocalDateTime writedate;

    // TODO: cnt - int
    private int cnt;
}
