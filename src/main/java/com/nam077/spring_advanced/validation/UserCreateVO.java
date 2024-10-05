package com.nam077.spring_advanced.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
public class UserCreateVO {


    @Schema(description = "User creation request object", example = "John Doe")
    @NotBlank(message = "{user.validation.name.required}")
    private String name;

    @Schema(description = "User password", example = "password")
    @NotBlank(message = "{user.validation.password.required}")
    private String password;

    @Schema(description = "User email", example = "dem@example.com")
    @NotBlank(message = "{user.validation.email.required}")
    @Email(message = "{user.validation.email.invalid}")
    private String email;
}
