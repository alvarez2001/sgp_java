package com.diocesisdecarupano.sgp.modules.wallet.application.usecase;

import org.springframework.stereotype.Service;

import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletResponseDTO;
import com.diocesisdecarupano.sgp.modules.wallet.domain.ports.WalletRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListWalletsUseCase {
    private final WalletRepositoryPort repository;
    private final UserRepositoryPort userRepositoryPort;

    public ListWalletsUseCase(WalletRepositoryPort repository, UserRepositoryPort userRepositoryPort) {
        this.repository = repository;
        this.userRepositoryPort = userRepositoryPort;
    }

    public List<WalletResponseDTO> execute(String email) {

        Optional<User> user = userRepositoryPort.findByEmail(email);
        if (user.isEmpty()) {
            throw new BadRequestException("Email no exists");
        }

        Long userId = user.get().getId();

        return repository.findAllByUserId(userId)
                .stream()
                .map(w -> WalletResponseDTO.builder()
                        .id(w.getId())
                        .userId(w.getUserId())
                        .name(w.getName())
                        .type(w.getType().name())
                        .currency(w.getCurrency().name())
                        .currentBalance(w.getCurrentBalance())
                        .build())
                .collect(Collectors.toList());
    }
}
