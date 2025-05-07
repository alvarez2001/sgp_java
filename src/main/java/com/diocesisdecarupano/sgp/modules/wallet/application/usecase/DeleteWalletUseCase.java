package com.diocesisdecarupano.sgp.modules.wallet.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.modules.wallet.domain.ports.WalletRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class DeleteWalletUseCase {
    private final WalletRepositoryPort repository;
    private final UserRepositoryPort userRepositoryPort;

    public DeleteWalletUseCase(WalletRepositoryPort repository, UserRepositoryPort userRepositoryPort) {
        this.repository = repository;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Transactional
    public void execute(String email, Long walletId) {
        Optional<User> user = userRepositoryPort.findByEmail(email);
        if (user.isEmpty()) {
            throw new BadRequestException("Email no exists");
        }
        Long userId = user.get().getId();

        var existing = repository.findById(walletId)
                .filter(wallet -> wallet.getUserId().equals(userId))
                .orElseThrow(() -> new BadRequestException("Wallet not found"));

        repository.deleteById(existing.getId());
    }
}
