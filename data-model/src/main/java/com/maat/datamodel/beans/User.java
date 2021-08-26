package com.maat.datamodel.beans;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String lastName;
    private MediaObject profileImage;
    private String userName;
    private String password;
    private boolean deleted;
}
