package com.diocesisdecarupano.sgp.modules.auth.application.usecase;

import com.diocesisdecarupano.sgp.modules.auth.application.dto.RegisterRequestDTO;
import com.diocesisdecarupano.sgp.modules.auth.application.dto.RegisterResponseDTO;
import com.diocesisdecarupano.sgp.modules.auth.application.mapper.AuthMapper;
import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;
import com.diocesisdecarupano.sgp.shared.infrastructure.provider.JwtTokenProvider;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public RegisterUserUseCase(UserRepositoryPort userRepository,
            PasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public RegisterResponseDTO execute(RegisterRequestDTO request) {
        request.setEmail(request.getEmail().toLowerCase());
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("username already in use");
        }

        User user = AuthMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User saved = userRepository.save(user);

        String token = jwtTokenProvider.createToken(saved.getUsername());

        RegisterResponseDTO registerResponseDTO = RegisterResponseDTO.builder()
                .token(token)
                .refreshToken(token)
                .build();

        return registerResponseDTO;
    }
}