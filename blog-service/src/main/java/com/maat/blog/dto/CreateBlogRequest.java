package com.maat.blog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maat.datamodel.beans.Blog;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBlogRequest {
    @NotNull(message = "Blog post without title is not allowed")
    private String title;
    @NotNull(message = "Blog post without contents is not allowed")
    private String content;

    public Blog createBlog() {
        Blog blog = new Blog();
        applyToExisting(blog);
        return blog;
    }

    private void applyToExisting(Blog blog) {
        blog.setTitle(title);
        blog.setContent(content);
    }
}
