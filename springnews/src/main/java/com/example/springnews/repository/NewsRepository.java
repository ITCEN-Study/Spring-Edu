package com.example.springnews.repository;

import com.example.springnews.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    
    // TODO: 뉴스 글 내용에서 검색 기능이 필요하며 (findByContentContaining)
    List<News> findByContentContaining(String keyword);
    
    // TODO: 작성자가 작성한 뉴스 글만 출력 기능 (findByWriter)
    List<News> findByWriter(String writer);

    // TODO: 글 한 개를 읽은 경우에는 cnt 변경도 필요하다.
    @Modifying
    @Query("update News n set n.cnt = n.cnt + 1 where n.id = :id")
    void updateCnt(@Param("id") int id);
}
