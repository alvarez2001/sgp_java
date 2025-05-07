package com.diocesisdecarupano.sgp.modules.user.application.usecase;

import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteUserUseCase {

    private final UserRepositoryPort userRepository;

    public DeleteUserUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void execute(Long id) {
        if (!userRepository.findById(id).isPresent()) {
            throw new BadRequestException("User not found");
        }
        userRepository.deleteById(id);
    }
}