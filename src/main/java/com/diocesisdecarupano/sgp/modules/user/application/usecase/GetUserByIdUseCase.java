package com.diocesisdecarupano.sgp.modules.user.application.usecase;

import com.diocesisdecarupano.sgp.modules.user.application.dto.UserResponseDTO;
import com.diocesisdecarupano.sgp.modules.user.application.mapper.UserMapper;
import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetUserByIdUseCase {

    private final UserRepositoryPort userRepository;

    public GetUserByIdUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public UserResponseDTO execute(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return UserMapper.toDTO(user);
    }
}