package com.diocesisdecarupano.sgp.modules.bank.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankResponseDTO;
import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankUpdateRequestDTO;
import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;
import com.diocesisdecarupano.sgp.modules.bank.domain.model.BankModel;
import com.diocesisdecarupano.sgp.modules.bank.domain.port.BankRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class UpdateBankUseCase {
    @Autowired
    private BankRepositoryPort repository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public BankResponseDTO execute(Long id, BankUpdateRequestDTO request) {
        BankModel existing = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Bank not found"));

        if (StringUtils.hasText(request.getAlias())) {
            existing.setAlias(request.getAlias());
        }

        if (StringUtils.hasText(request.getAccountHolder())) {
            existing.setAccountHolder(request.getAccountHolder());
        }

        if (request.getType() != null) {
            existing.setType(request.getType());
        }

        if (StringUtils.hasText(request.getAccountNumber())) {
            existing.setAccountNumber(request.getAccountNumber());

            boolean existsAccountNumber = repository.existsByAccountNumber(existing.getAccountNumber());

            if (existsAccountNumber && existing.getType().equals(BankType.TRANSFERENCIA)) {
                throw new BadRequestException("El numero de cuenta ya existe para transferencia");
            }
        }

        if (StringUtils.hasText(request.getBankName())) {
            existing.setBankName(request.getBankName());
        }

        if (StringUtils.hasText(request.getIdentification())) {
            existing.setIdentification(request.getIdentification());
        }

        existing = repository.save(existing);
        return modelMapper.map(existing, BankResponseDTO.class);
    }
}
