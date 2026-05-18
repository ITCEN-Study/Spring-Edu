package com.example.springnews.controller;

import com.example.springnews.model.News;
import com.example.springnews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    // TODO: GET 방식 - 전체 뉴스 출력 (매핑명 : /newsmain)
    @GetMapping("/newsmain")
    public String listAll(@RequestParam(required = false) String action, Model model) {
        List<News> list = newsRepository.findAll();
        model.addAttribute("list", list);
        if ("insert".equals(action)) {
            model.addAttribute("insert", true);
        }
        return "news";
    }

    // TODO: GET 방식 - 뉴스 id 로 해당 뉴스 내용 출력 (매핑명 : /one)
    @Transactional
    @GetMapping("/one")
    public String viewOne(@RequestParam int id, Model model) {
        // TODO: 글 한 개를 읽은 경우에는 cnt 변경도 필요하다.
        newsRepository.updateCnt(id);
        News news = newsRepository.findById(id).orElse(null);
        model.addAttribute("news", news);
        model.addAttribute("list", newsRepository.findAll());
        return "news";
    }

    // TODO: GET 방식 - 뉴스 id 로 뉴스 삭제 (매핑명 : /delete)
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        newsRepository.deleteById(id);
        return "redirect:/newsmain";
    }

    // TODO: GET 방식 - 전달된 검색어로 뉴스글 내용에서 검색하여 결과 출력 (매핑명 : /search)
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<News> list = newsRepository.findByContentContaining(keyword);
        model.addAttribute("list", list);
        if (list.isEmpty()) {
            model.addAttribute("msg", "검색 결과가 존재하지 않습니다.");
        }
        return "news";
    }

    // TODO: GET 방식 - 작성자가 작성한 뉴스 글만 출력 (매핑명 : /writer)
    @GetMapping("/writer")
    public String searchByWriter(@RequestParam String name, Model model) {
        List<News> list = newsRepository.findByWriter(name);
        model.addAttribute("list", list);
        return "news";
    }

    // TODO: POST 방식 - 뉴스 작성 (매핑명 : /insert)
    @PostMapping("/insert")
    public String insert(News news) {
        newsRepository.save(news);
        return "redirect:/newsmain";
    }

    // TODO: POST 방식 - 뉴스 수정 (매핑명 : /update)
    @PostMapping("/update")
    public String update(News news) {
        News existingNews = newsRepository.findById(news.getId()).orElse(null);
        if (existingNews != null) {
            existingNews.setWriter(news.getWriter());
            existingNews.setTitle(news.getTitle());
            existingNews.setContent(news.getContent());
            newsRepository.save(existingNews);
        }
        return "redirect:/newsmain";
    }
}
