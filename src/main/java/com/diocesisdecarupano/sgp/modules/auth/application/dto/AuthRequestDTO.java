package com.diocesisdecarupano.sgp.modules.auth.application.dto;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequestDTO {

    @NotBlank(message = "username is required")
    @NotNull(message = "username not null")
    @Size(message = "username is min 1 and max 30", min = 1, max = 30)
    private String username;


    @NotBlank(message = "password is required")
    @NotNull(message = "password not null")
    @Size(message = "password is min 1 and max 190", min = 1, max = 190)
    private String password;
}