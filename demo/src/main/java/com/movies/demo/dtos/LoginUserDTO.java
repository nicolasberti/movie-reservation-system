package com.movies.demo.dtos;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class LoginUserDTO {
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
