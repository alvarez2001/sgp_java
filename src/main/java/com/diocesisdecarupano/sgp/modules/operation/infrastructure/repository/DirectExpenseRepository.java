package com.diocesisdecarupano.sgp.modules.operation.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.operation.infrastructure.persistence.DirectExpense;

@Repository
public interface DirectExpenseRepository extends JpaRepository<DirectExpense, Long> {
    // Puedes agregar métodos como List<EgresosDirectos> findByProyectoId(Long id);
}