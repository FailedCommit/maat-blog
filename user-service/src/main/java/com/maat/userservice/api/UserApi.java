package com.maat.userservice.api;

import com.maat.datamodel.beans.User;
import com.maat.userservice.dto.CreateUserRequest;
import com.maat.userservice.dto.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    @GetMapping("/hi")
    public String greet() {
        return "Hello there!! user..";
    }

    @PostMapping
    public ResponseEntity<User> create(CreateUserRequest request) {
        log.info("User Created");
        return ResponseEntity.ok(new User());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        log.info("User fetched");
        return ResponseEntity.ok(new User());
    }

    @PutMapping
    public ResponseEntity<User> update(UpdateUserRequest request) {
        log.info("User Updated");
        return ResponseEntity.ok(new User());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") String id) {
        log.info("User Deleted");
        return ResponseEntity.ok(new User());
    }
}
