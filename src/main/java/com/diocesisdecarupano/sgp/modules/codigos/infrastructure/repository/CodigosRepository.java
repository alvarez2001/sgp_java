package com.diocesisdecarupano.sgp.modules.codigos.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.codigos.infrastructure.persistence.Codigos;

@Repository
public interface CodigosRepository extends JpaRepository<Codigos, Long> {
    // Ejemplo de método personalizado:
    boolean existsByCodigo(String codigo);
}