package com.maat.blog.api;

import com.maat.blog.dto.CreateBlogRequest;
import com.maat.blog.dto.UpdateBlogRequest;
import com.maat.blog.services.BlogService;
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
    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody CreateBlogRequest request) {
        Blog blog = blogService.createBlog(request);
        log.info("Blog Created");
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") String id) {
        Blog blog = blogService.getBlogById(id);
        log.info("Blog fetched");
        return ResponseEntity.ok(blog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(
            @PathVariable("id") String id,
            @RequestBody UpdateBlogRequest request) {
        Blog blog = blogService.updateBlog(id, request);
        log.info("Blog Updated");
        return ResponseEntity.ok(blog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") String id) {
        final Blog deleteBlog = blogService.delete(id);
        log.info("Blog Deleted");
        return ResponseEntity.ok(deleteBlog);
    }
}
