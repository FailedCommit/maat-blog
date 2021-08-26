package com.maat.userservice.services;

import com.maat.datamodel.beans.User;
import com.maat.datamodel.beans.User;
import com.maat.userservice.dto.CreateUserRequest;
import com.maat.userservice.dto.UpdateUserRequest;
import com.maat.userservice.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public User createUser(CreateUserRequest request) {
        final User user = request.createUser();
        return userRepo.save(user);
    }

    public User getUserById(String id) {
        final Optional<User> userOption = userRepo.findById(id);
        final User user = userOption.get();
        if(user.isDeleted()) throw new RuntimeException("User not found");
        return user;
    }

    public User updateUser(String id, UpdateUserRequest request) {
        User existingUser = getUserById(id);
        if(existingUser.isDeleted()) throw new RuntimeException("User not found");
        request.applyToExisting(existingUser);
        return userRepo.save(existingUser);
    }

    public User delete(String id) {
        User existingUser = getUserById(id);
        existingUser.setDeleted(true);
        return userRepo.save(existingUser);
    }
}
