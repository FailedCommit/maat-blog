package com.maat.mediaservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaUploadRequest {
    private String fileName;
    private String fileLocation;
}
