package com.diocesisdecarupano.sgp.modules.auth.application.usecase;

import com.diocesisdecarupano.sgp.modules.auth.application.dto.AuthRequestDTO;
import com.diocesisdecarupano.sgp.modules.auth.application.dto.AuthResponseDTO;
import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;
import com.diocesisdecarupano.sgp.shared.infrastructure.provider.JwtTokenProvider;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginUserUseCase(UserRepositoryPort userRepository,
            PasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public AuthResponseDTO execute(AuthRequestDTO request) {

        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isEmpty() || !passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
            throw new BadRequestException("Invalid username or password.");
        }

        User user = userOpt.get();
        String token = jwtTokenProvider.createToken(user.getUsername());

        AuthResponseDTO authResponseDTO = AuthResponseDTO.builder().token(token).refreshToken(token).build();

        return authResponseDTO;
    }
}