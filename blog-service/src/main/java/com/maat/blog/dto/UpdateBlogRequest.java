package com.maat.blog.dto;

import com.maat.datamodel.beans.Blog;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateBlogRequest {
    @NotNull(message = "Blog post without title is not allowed")
    private String title;
    @NotNull(message = "Blog post without contents is not allowed")
    private String content;

    public void applyToExisting(Blog blog) {
        blog.setTitle(title);
        blog.setContent(content);
    }
}
