package com.maat.datamodel.beans;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    private String firstName;
    private String lastName;
    private MediaObject profileImage;
    @Indexed(unique = true)
    private String username;
    // PII
    private String email;
    private boolean deleted;
}
