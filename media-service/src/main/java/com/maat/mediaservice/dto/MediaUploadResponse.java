package com.maat.mediaservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaUploadResponse {
    private String fileName;
    private String fileLocation;
    private String fileType;
}
