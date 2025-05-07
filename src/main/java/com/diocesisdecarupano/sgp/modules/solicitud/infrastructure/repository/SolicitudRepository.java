package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    // Puedes agregar métodos como: List<Solicitud> findByUsuarioId(Long id);
}