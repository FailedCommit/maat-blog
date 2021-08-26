package com.maat.datamodel.beans;

import lombok.Data;

@Data
public class Comment extends Post {
    private String blogId;
    private String parentCommentId;
    private int likes;
    private int dislikes;
}

