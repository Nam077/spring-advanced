package com.nam077.spring_advanced.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateVO {

    @NotBlank(message = "{user.validation.username.required}")
    private String username;

    private String password; // Có thể để trống khi cập nhật

    @NotBlank(message = "{user.validation.email.required}")
    @Email(message = "{user.validation.email.invalid}")
    private String email;
}
