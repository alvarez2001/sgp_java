package com.diocesisdecarupano.sgp.modules.auth.application.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDTO {
    private String token;
    private String refreshToken;
}
