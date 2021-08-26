package com.maat.blog.api;

import com.maat.blog.dto.CreateBlogRequest;
import com.maat.blog.dto.UpdateBlogRequest;
import com.maat.datamodel.beans.Blog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogApi {
    @GetMapping("/hi")
    public String greet() {
        return "Hello there!! blog..";
    }

    @PostMapping
    public ResponseEntity<Blog> create(CreateBlogRequest request) {
        log.info("Blog Created");
        return ResponseEntity.ok(new Blog());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") String id) {
        log.info("Blog fetched");
        return ResponseEntity.ok(new Blog());
    }

    @PutMapping
    public ResponseEntity<Blog> update(UpdateBlogRequest request) {
        log.info("Blog Updated");
        return ResponseEntity.ok(new Blog());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") String id) {
        log.info("Blog Deleted");
        return ResponseEntity.ok(new Blog());
    }
}
