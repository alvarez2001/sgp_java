package com.diocesisdecarupano.sgp.modules.bank.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.bank.infrastructure.persistence.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    // Puedes agregar métodos personalizados aquí si los necesitas
}