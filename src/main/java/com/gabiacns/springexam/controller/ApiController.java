package com.gabiacns.springexam.controller;

import com.gabiacns.springexam.controller.request.CreateUserRequest;
import com.gabiacns.springexam.model.User;
import com.gabiacns.springexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/user")
    public String user() {
        User user = new User();
        user.setName("재욱");
        user.setPassword("1234");
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return String.valueOf(savedUser.getId());
    }

    @GetMapping("/user/${id}")
    public String getUser(@PathVariable(value = "id") Long id) {

        User user = userRepository.findById(id)
                .orElse(new User());

        return user.getName();
    }

    @PostMapping("/user")
    public String addUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        var saved = userRepository.save(user);

        return String.valueOf(saved.getId());
    }
}
