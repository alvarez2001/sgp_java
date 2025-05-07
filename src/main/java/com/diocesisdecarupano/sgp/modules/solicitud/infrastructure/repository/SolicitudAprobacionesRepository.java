package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence.SolicitudAprobaciones;

@Repository
public interface SolicitudAprobacionesRepository extends JpaRepository<SolicitudAprobaciones, Long> {
    // Puedes agregar métodos como: Optional<SolicitudAprobaciones> findBySolicitudId(Long id);
}