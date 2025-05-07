package com.diocesisdecarupano.sgp.modules.user.application.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {

    private String name;

    private String lastName;

    private String nationality;

    private String identification;

    private String username;

    private String email;

    private byte type;

    private byte state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}