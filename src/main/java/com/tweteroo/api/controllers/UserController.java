package com.tweteroo.api.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
    final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> postUser(@RequestBody @Valid UserDTO body) {
        Optional<UserModel> user = userService.save(body);

        if(!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A username already exists!");    
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
