package com.diocesisdecarupano.sgp.modules.user.application.usecase;

import com.diocesisdecarupano.sgp.modules.user.application.dto.UserRequestDTO;
import com.diocesisdecarupano.sgp.modules.user.application.dto.UserResponseDTO;
import com.diocesisdecarupano.sgp.modules.user.application.mapper.UserMapper;
import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CreateUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserUseCase(UserRepositoryPort userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDTO execute(UserRequestDTO requestDto) {
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new BadRequestException("username already in use");
        }

        User user = UserMapper.toEntity(requestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }
}
