package com.diocesisdecarupano.sgp.modules.operation.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.operation.infrastructure.persistence.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    // Puedes agregar consultas personalizadas si lo necesitas
}