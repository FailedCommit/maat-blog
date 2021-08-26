package com.maat.datamodel.beans;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class MediaObject {
    private String id;
    private String fileName;
    private String fileType;
    private String location;
    private boolean deleted;
}
