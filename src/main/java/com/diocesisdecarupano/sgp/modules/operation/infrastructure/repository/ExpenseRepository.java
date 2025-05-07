package com.diocesisdecarupano.sgp.modules.operation.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.operation.infrastructure.persistence.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}