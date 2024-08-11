package org.pictura.sample_chat_application.controller;

import lombok.RequiredArgsConstructor;
import org.pictura.sample_chat_application.model.User;
import org.pictura.sample_chat_application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/disconnect")
    public ResponseEntity<User> disconnectUser(@RequestBody User user) {
        userService.disconnect(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/connected")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}


