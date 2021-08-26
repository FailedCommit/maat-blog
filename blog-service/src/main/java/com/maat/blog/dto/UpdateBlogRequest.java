package com.maat.blog.dto;

import lombok.Data;

@Data
public class UpdateBlogRequest {
    private String title;
    private String content;
}
