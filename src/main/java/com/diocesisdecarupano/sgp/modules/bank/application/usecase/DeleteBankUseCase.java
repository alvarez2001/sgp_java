package com.diocesisdecarupano.sgp.modules.bank.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.bank.domain.port.BankRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class DeleteBankUseCase {
    @Autowired
    private BankRepositoryPort repository;

    @Transactional
    public void execute(Long id) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Bank not found"));

        repository.deleteById(existing.getId());
    }
}
