package com.maat.userservice.api;

import com.maat.datamodel.beans.User;
import com.maat.datamodel.beans.User;
import com.maat.userservice.dto.CreateUserRequest;
import com.maat.userservice.dto.UpdateUserRequest;
import com.maat.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);
        log.info("User Created");
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        User user = userService.getUserById(id);
        log.info("User fetched");
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable("id") String id,
            @RequestBody UpdateUserRequest request) {
        User user = userService.updateUser(id, request);
        log.info("User Updated");
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") String id) {
        final User deleteUser = userService.delete(id);
        log.info("User Deleted");
        return ResponseEntity.ok(deleteUser);
    }
}
