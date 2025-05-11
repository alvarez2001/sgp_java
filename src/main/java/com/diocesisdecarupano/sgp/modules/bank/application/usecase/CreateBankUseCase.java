package com.diocesisdecarupano.sgp.modules.bank.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankRequestDTO;
import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankResponseDTO;
import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;
import com.diocesisdecarupano.sgp.modules.bank.domain.model.BankModel;
import com.diocesisdecarupano.sgp.modules.bank.domain.port.BankRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class CreateBankUseCase {

    @Autowired
    private BankRepositoryPort repository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public BankResponseDTO execute(BankRequestDTO request) {
        BankModel domain = modelMapper.map(request, BankModel.class);

        boolean existsAccountNumber = repository.existsByAccountNumber(domain.getAccountNumber());

        if (existsAccountNumber && domain.getType().equals(BankType.TRANSFERENCIA)) {
            throw new BadRequestException("El numero de cuenta ya existe para transferencia");
        }

        BankModel saved = repository.save(domain);
        return modelMapper.map(saved, BankResponseDTO.class);
    }

}
