package com.maat.mediaservice.beans;

import lombok.Data;

@Data
public class MediaObject {
    private String id;
    private String fileName;
    private String fileType;
    private String location;
    private boolean deleted;
}
