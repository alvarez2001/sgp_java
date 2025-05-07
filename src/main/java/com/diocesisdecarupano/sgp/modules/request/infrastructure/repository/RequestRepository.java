package com.diocesisdecarupano.sgp.modules.request.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    // Puedes agregar métodos como: List<Solicitud> findByUsuarioId(Long id);
}