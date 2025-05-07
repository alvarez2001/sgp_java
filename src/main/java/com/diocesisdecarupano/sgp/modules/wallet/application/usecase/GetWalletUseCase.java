package com.diocesisdecarupano.sgp.modules.wallet.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletResponseDTO;
import com.diocesisdecarupano.sgp.modules.wallet.domain.ports.WalletRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service

public class GetWalletUseCase {
    private final WalletRepositoryPort repository;
    private final UserRepositoryPort userRepositoryPort;

    public GetWalletUseCase(WalletRepositoryPort repository, UserRepositoryPort userRepositoryPort) {
        this.repository = repository;
        this.userRepositoryPort = userRepositoryPort;
    }

    public WalletResponseDTO execute(String email, Long walletId) {

        Optional<User> user = userRepositoryPort.findByEmail(email);
        if (user.isEmpty()) {
            throw new BadRequestException("Email no exists");
        }
        Long userId = user.get().getId();

        var wallet = repository.findById(walletId)
                .filter(w -> w.getUserId().equals(userId))
                .orElseThrow(() -> new BadRequestException("Wallet not found"));

        return WalletResponseDTO.builder()
                .id(wallet.getId())
                .userId(wallet.getUserId())
                .name(wallet.getName())
                .type(wallet.getType().name())
                .currency(wallet.getCurrency().name())
                .currentBalance(wallet.getCurrentBalance())
                .build();
    }
}
