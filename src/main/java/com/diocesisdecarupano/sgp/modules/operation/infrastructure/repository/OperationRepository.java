package com.diocesisdecarupano.sgp.modules.operation.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.operation.infrastructure.persistence.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    // Métodos personalizados si necesitas buscar por fecha, banco, etc.
}