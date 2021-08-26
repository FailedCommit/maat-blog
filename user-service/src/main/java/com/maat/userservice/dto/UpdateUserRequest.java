package com.maat.userservice.dto;

import com.maat.datamodel.beans.Blog;
import com.maat.datamodel.beans.MediaObject;
import com.maat.datamodel.beans.User;

import javax.validation.constraints.NotNull;

public class UpdateUserRequest {
    @NotNull(message = "User without a first name is not allowed")
    private String firstName;
    @NotNull(message = "User without lastName is not allowed")
    private String lastName;
    @NotNull(message = "User without username is not allowed")
    private String username;

    public void applyToExisting(User user) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }
}
/*
    private String firstName;
    private String lastName;
    private MediaObject profileImage;
    private String userName;
    private String password;
    private boolean deleted;
 */