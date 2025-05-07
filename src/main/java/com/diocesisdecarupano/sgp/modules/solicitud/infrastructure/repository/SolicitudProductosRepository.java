package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence.SolicitudProductos;

@Repository
public interface SolicitudProductosRepository extends JpaRepository<SolicitudProductos, Long> {
    // Ejemplo: List<SolicitudProductos> findBySolicitudId(Long solicitudId);
}