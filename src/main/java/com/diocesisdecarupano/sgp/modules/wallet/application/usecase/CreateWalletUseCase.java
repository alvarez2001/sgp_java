package com.diocesisdecarupano.sgp.modules.wallet.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletRequestDTO;
import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletResponseDTO;
import com.diocesisdecarupano.sgp.modules.wallet.domain.model.Wallet;
import com.diocesisdecarupano.sgp.modules.wallet.domain.ports.WalletRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class CreateWalletUseCase {

    private final WalletRepositoryPort repository;
    private final UserRepositoryPort userRepositoryPort;

    public CreateWalletUseCase(WalletRepositoryPort repository, UserRepositoryPort userRepositoryPort) {
        this.repository = repository;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Transactional
    public WalletResponseDTO execute(String email, WalletRequestDTO request) {

        Optional<User> user = userRepositoryPort.findByEmail(email);
        if (user.isEmpty()) {
            throw new BadRequestException("Email no exists");
        }
        Long userId = user.get().getId();

        // Mapear request DTO a entidad de dominio
        Wallet domain = Wallet.builder()
                .id(null)
                .userId(userId)
                .name(request.getName())
                .type(request.getType())
                .currency(request.getCurrency())
                .currentBalance(request.getInitialBalance())
                .state(true)
                .build();

        // Guardar en repositorio
        Wallet saved = repository.save(domain);

        // Mapear dominio a response DTO
        WalletResponseDTO response = WalletResponseDTO.builder()
                .id(saved.getId())
                .userId(saved.getUserId())
                .name(saved.getName())
                .type(saved.getType().name())
                .currency(saved.getCurrency().name())
                .currentBalance(saved.getCurrentBalance())
                .build();

        return response;
    }
}
