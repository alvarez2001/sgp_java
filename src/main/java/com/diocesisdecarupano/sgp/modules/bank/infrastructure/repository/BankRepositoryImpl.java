package com.diocesisdecarupano.sgp.modules.bank.infrastructure.repository;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.bank.domain.model.BankModel;
import com.diocesisdecarupano.sgp.modules.bank.domain.port.BankRepositoryPort;
import com.diocesisdecarupano.sgp.modules.bank.infrastructure.entity.Bank;
import com.diocesisdecarupano.sgp.modules.bank.infrastructure.specification.BankSearchSpecification;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BankRepositoryImpl implements BankRepositoryPort {
    @Autowired
    private final BankJpaRepository jpa;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public BankModel save(BankModel domain) {
        Bank bank = modelMapper.map(domain, Bank.class);
        Bank saved = jpa.save(bank);
        BankModel bankM = modelMapper.map(saved, BankModel.class);
        return bankM;
    }

    @Override
    public Optional<BankModel> findById(Long id) {
        return jpa.findById(id).map(bank -> modelMapper.map(bank, BankModel.class));

    }

    @Override
    public List<BankModel> findAll() {
        return jpa.findAll()
                .stream()
                .map(bank -> modelMapper.map(bank, BankModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<BankModel> paginate(BankSearchCriteriaDTO searchCriteriaDTO, Pageable pageable) {
        BankSearchSpecification bankSearchSpecification = new BankSearchSpecification(searchCriteriaDTO);
        Page<Bank> entities = jpa.findAll(bankSearchSpecification, pageable);
        return entities.map(entity -> modelMapper.map(entity, BankModel.class));
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return jpa.existsByAccountNumber(accountNumber);
    }

}
