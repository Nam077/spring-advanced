package com.nam077.spring_advanced.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nam077.spring_advanced.dto.ResponseDto;
import com.nam077.spring_advanced.dto.ResponseDto;
import com.nam077.spring_advanced.dto.UserDTO;
import com.nam077.spring_advanced.exception.ConflictException;
import com.nam077.spring_advanced.model.User;
import com.nam077.spring_advanced.service.UserService;
import com.nam077.spring_advanced.validation.UserCreateVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "User", description = "Operations related to user management")
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public ResponseEntity<ResponseDto<UserDTO>> createUser(@Valid @RequestBody UserCreateVO userCreateVO) {

        UserDTO userDTO = new UserDTO();
        userDTO.setName(userCreateVO.getName());
        userDTO.setEmail(userCreateVO.getEmail());
        userDTO.setPassword(userCreateVO.getPassword());

        UserDTO newUserDTO = userService.createUser(userDTO);
        ResponseDto<UserDTO> responseDto = new ResponseDto<>(newUserDTO, "User created successfully", true,
                HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatsus.CREATED).body(responseDto);
    }

}
