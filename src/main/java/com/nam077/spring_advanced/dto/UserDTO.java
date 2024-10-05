package com.nam077.spring_advanced.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private UUID id;
    private String name;
    private String password;
    private String email;
    private Boolean deleted;
    private Date createdAt;
    private Date updatedAt;
}
