package com.nam077.spring_advanced.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nam077.spring_advanced.validation.UserCreateVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "User", description = "Operations related to user management")
@RequestMapping("/api/users")

public class UserController {

    @PostMapping
    @Operation(summary = "Create a new user")
    public String createUser(@Valid @RequestBody UserCreateVO userCreateVO) {
        
        return "User created: " + userCreateVO;
    }

}
