package com.diocesisdecarupano.sgp.modules.bank.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankResponseDTO;
import com.diocesisdecarupano.sgp.modules.bank.domain.model.BankModel;
import com.diocesisdecarupano.sgp.modules.bank.domain.port.BankRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service

public class GetBankUseCase {

    @Autowired
    private BankRepositoryPort repository;
    private final ModelMapper modelMapper = new ModelMapper();

    public BankResponseDTO execute(Long id) {

        BankModel bank = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Bank not found"));

        return modelMapper.map(bank, BankResponseDTO.class);
    }
}
