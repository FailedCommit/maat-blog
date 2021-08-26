package com.maat.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maat.datamodel.beans.User;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest {
    @NotNull(message = "User without a first name is not allowed")
    private String firstName;
    @NotNull(message = "User without lastName is not allowed")
    private String lastName;
    @NotNull(message = "User without username is not allowed")
    private String username;
    @NotNull(message = "Please provide a working email. Without email verification account will not be activated")
    private String email;

    public User createUser() {
        User user = new User();
        applyToExisting(user);
        return user;
    }

    private void applyToExisting(User user) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
    }
}
