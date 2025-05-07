package com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.persistence.Operaciones;

@Repository
public interface OperacionesRepository extends JpaRepository<Operaciones, Long> {
    // Métodos personalizados si necesitas buscar por fecha, banco, etc.
}