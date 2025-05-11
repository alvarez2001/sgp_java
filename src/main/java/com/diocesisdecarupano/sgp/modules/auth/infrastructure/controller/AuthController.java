package com.diocesisdecarupano.sgp.modules.auth.infrastructure.controller;

import com.diocesisdecarupano.sgp.modules.auth.application.dto.AuthRequestDTO;
import com.diocesisdecarupano.sgp.modules.auth.application.dto.AuthResponseDTO;
import com.diocesisdecarupano.sgp.modules.auth.application.dto.RegisterRequestDTO;
import com.diocesisdecarupano.sgp.modules.auth.application.dto.RegisterResponseDTO;
import com.diocesisdecarupano.sgp.modules.auth.application.usecase.LoginUserUseCase;
import com.diocesisdecarupano.sgp.modules.auth.application.usecase.RegisterUserUseCase;
import com.diocesisdecarupano.sgp.shared.infrastructure.anotations.Public;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Public
@Tag(name = "Auth", description = "Controller for Authentication")
public class AuthController {

    private final LoginUserUseCase loginUserUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    public AuthController(LoginUserUseCase loginUserUseCase, RegisterUserUseCase registerUserUseCase) {
        this.loginUserUseCase = loginUserUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO request) {
        AuthResponseDTO response = loginUserUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
        RegisterResponseDTO response = registerUserUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}