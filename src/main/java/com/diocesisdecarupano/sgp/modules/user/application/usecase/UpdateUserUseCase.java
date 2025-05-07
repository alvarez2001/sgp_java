package com.diocesisdecarupano.sgp.modules.user.application.usecase;

import com.diocesisdecarupano.sgp.modules.user.application.dto.UserRequestDTO;
import com.diocesisdecarupano.sgp.modules.user.application.dto.UserResponseDTO;
import com.diocesisdecarupano.sgp.modules.user.application.mapper.UserMapper;
import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateUserUseCase {

    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;

    public UpdateUserUseCase(UserRepositoryPort userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDTO execute(Long id, UserRequestDTO requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));

        // user.setName(requestDto.getName());
        // user.setEmail(requestDto.getEmail());

        // if (requestDto.getPassword() != null && !requestDto.getPassword().isEmpty())
        // {
        // user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        // }

        // User updatedUser = userRepository.save(user);
        return UserMapper.toDTO(user);
    }
}