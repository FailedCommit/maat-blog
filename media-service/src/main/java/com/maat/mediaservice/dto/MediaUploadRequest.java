package com.maat.mediaservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

//TODO: Maybe this is not required, can be deleted!!!

@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaUploadRequest {
    private String fileName;
    private String fileLocation;
}
