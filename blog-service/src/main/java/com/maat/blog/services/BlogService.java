package com.maat.blog.services;

import com.maat.blog.dto.CreateBlogRequest;
import com.maat.blog.dto.UpdateBlogRequest;
import com.maat.blog.repo.BlogRepository;
import com.maat.datamodel.beans.Blog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogService {
    private final BlogRepository blogRepo;

    public Blog createBlog(CreateBlogRequest request) {
        final Blog blog = request.createBlog();
        return blogRepo.save(blog);
    }

    public Blog getBlogById(String id) {
        final Optional<Blog> blogOption = blogRepo.findById(id);
        final Blog blog = blogOption.get();
        if(blog.isDeleted()) throw new RuntimeException("Blog not found");
        return blog;
    }

    public Blog updateBlog(String id, UpdateBlogRequest request) {
        Blog existingBlog = getBlogById(id);
        if(existingBlog.isDeleted()) throw new RuntimeException("Blog not found");
        request.applyToExisting(existingBlog);
        return blogRepo.save(existingBlog);
    }

    public Blog delete(String id) {
        Blog existingBlog = getBlogById(id);
        existingBlog.setDeleted(true);
        return blogRepo.save(existingBlog);
    }
}
