package com.diocesisdecarupano.sgp.modules.bank.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankResponseDTO;
import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.bank.domain.port.BankRepositoryPort;

@Service
public class PaginateBankUseCase {

    @Autowired
    private BankRepositoryPort repository;
    private final ModelMapper modelMapper = new ModelMapper();

    public Page<BankResponseDTO> execute(BankSearchCriteriaDTO bankSearchCriteriaDTO, Pageable pageable) {
        return repository.paginate(bankSearchCriteriaDTO, pageable)
                .map(bankModel -> modelMapper.map(bankModel, BankResponseDTO.class));
    }
}
