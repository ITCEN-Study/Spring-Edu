package com.example.springnews.repository;

import com.example.springnews.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    
    // Search by content
    List<News> findByContentContaining(String keyword);
    
    // Search by writer
    List<News> findByWriter(String writer);

    // Update view count
    @Modifying
    @Query("update News n set n.cnt = n.cnt + 1 where n.id = :id")
    void updateCnt(@Param("id") int id);
}
