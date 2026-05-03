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

    @GetMapping("/newsmain")
    public String listAll(@RequestParam(required = false) String action, Model model) {
        List<News> list = newsRepository.findAll();
        model.addAttribute("list", list);
        if ("insert".equals(action)) {
            model.addAttribute("insert", true);
        }
        return "news";
    }

    @Transactional
    @GetMapping("/one")
    public String viewOne(@RequestParam int id, Model model) {
        newsRepository.updateCnt(id);
        News news = newsRepository.findById(id).orElse(null);
        model.addAttribute("news", news);
        model.addAttribute("list", newsRepository.findAll());
        return "news";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        newsRepository.deleteById(id);
        return "redirect:/newsmain";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<News> list = newsRepository.findByContentContaining(keyword);
        model.addAttribute("list", list);
        if (list.isEmpty()) {
            model.addAttribute("msg", "검색 결과가 존재하지 않습니다.");
        }
        return "news";
    }

    @GetMapping("/writer")
    public String searchByWriter(@RequestParam String name, Model model) {
        List<News> list = newsRepository.findByWriter(name);
        model.addAttribute("list", list);
        return "news";
    }

    @PostMapping("/insert")
    public String insert(News news) {
        newsRepository.save(news);
        return "redirect:/newsmain";
    }

    @PostMapping("/update")
    public String update(News news) {
        // We need to keep the original writedate and cnt if they are not provided in the form
        // Or just let JPA handle it if we only update specific fields
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
