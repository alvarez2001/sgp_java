package com.diocesisdecarupano.sgp.modules.wallet.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletRequestDTO;
import com.diocesisdecarupano.sgp.modules.wallet.application.dto.WalletResponseDTO;
import com.diocesisdecarupano.sgp.modules.wallet.domain.ports.WalletRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class UpdateWalletUseCase {
    private final WalletRepositoryPort repository;
    private final UserRepositoryPort userRepositoryPort;

    public UpdateWalletUseCase(WalletRepositoryPort repository, UserRepositoryPort userRepositoryPort) {
        this.repository = repository;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Transactional
    public WalletResponseDTO execute(String email, Long walletId, WalletRequestDTO request) {

        Optional<User> user = userRepositoryPort.findByEmail(email);
        if (user.isEmpty()) {
            throw new BadRequestException("Email no exists");
        }
        Long userId = user.get().getId();

        var existing = repository.findById(walletId)
                .filter(w -> w.getUserId().equals(userId))
                .orElseThrow(() -> new BadRequestException("Wallet not found"));

        // existing.rename(request.getName());
        // existing.deposit(request.getInitialBalance().subtract(existing.getCurrentBalance()));
        existing = repository.save(existing);

        return WalletResponseDTO.builder()
                .id(existing.getId())
                .userId(existing.getUserId())
                .name(existing.getName())
                .type(existing.getType().name())
                .currency(existing.getCurrency().name())
                .currentBalance(existing.getCurrentBalance())
                .build();
    }
}
