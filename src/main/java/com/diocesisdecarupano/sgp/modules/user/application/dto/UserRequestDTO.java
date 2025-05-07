package com.diocesisdecarupano.sgp.modules.user.application.dto;

import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    @NotBlank(message = "Name is required")
    @NotNull(message = "Name not null")
    @Size(message = "Name is min 1 and max 120", min = 1, max = 120)
    private String name;

    @NotBlank(message = "lastName is required")
    @NotNull(message = "lastName not null")
    @Size(message = "lastName is min 1 and max 120", min = 1, max = 120)
    private String lastName;

    @NotBlank(message = "nationality is required")
    @NotNull(message = "nationality not null")
    @Size(message = "nationality is min 1 and max 1", min = 1, max = 1)
    private String nationality;

    @NotBlank(message = "identification is required")
    @NotNull(message = "identification not null")
    @Size(message = "identification is min 1 and max 20", min = 1, max = 20)
    private String identification;

    @NotBlank(message = "username is required")
    @NotNull(message = "username not null")
    @Size(message = "username is min 1 and max 30", min = 1, max = 30)
    private String username;

    @NotBlank(message = "username is required")
    @NotNull(message = "username not null")
    @Email(message = "Invalid email")
    @Size(message = "username is min 1 and max 130", min = 1, max = 130)
    private String email;

    @NotBlank(message = "password is required")
    @NotNull(message = "password not null")
    @Size(message = "password is min 1 and max 190", min = 1, max = 190)
    private String password;

    @NotBlank(message = "type is required")
    @NotNull(message = "type not null")
    @Size(message = "type is min 1 and max 1", min = 1, max = 1)
    private byte type;

    @NotBlank(message = "state is required")
    @NotNull(message = "state not null")
    @Size(message = "state is min 1 and max 1", min = 1, max = 1)
    private byte state;
}
