package com.maat.datamodel.beans;

import com.maat.datamodel.beans.enums.Rating;
import lombok.Data;

@Data
public class Post {
    private String id;
    private String title;
    private String content;
    private User author;
    private boolean deleted;
}
