package com.prject.myblog.controller;

import com.prject.myblog.domain.Blog;
import com.prject.myblog.domain.BlogRepository;
import com.prject.myblog.domain.BlogRequestDto;
import com.prject.myblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @GetMapping("/api/blogs")
    public List<Blog> getBlog() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }

    @PutMapping ("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id,@RequestBody BlogRequestDto requestDto){
        blogService.update(id,requestDto);
        return id;
    }
}
