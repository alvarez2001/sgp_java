package com.diocesisdecarupano.sgp.modules.user.application.usecase;

import com.diocesisdecarupano.sgp.modules.user.application.dto.UserResponseDTO;
import com.diocesisdecarupano.sgp.modules.user.application.mapper.UserMapper;
import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchUsersByNameUseCase {

    private final UserRepositoryPort userRepository;

    public SearchUsersByNameUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> execute(String name) {
        List<User> users = userRepository.findByNameContaining(name);
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}