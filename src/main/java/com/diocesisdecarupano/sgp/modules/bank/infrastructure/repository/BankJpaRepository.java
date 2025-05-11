package com.diocesisdecarupano.sgp.modules.bank.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.bank.infrastructure.entity.Bank;

@Repository
public interface BankJpaRepository extends JpaRepository<Bank, Long>, JpaSpecificationExecutor<Bank> {
    boolean existsByAccountNumber(String accountNumber);
}