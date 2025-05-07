package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence.SolicitudBancaria;

@Repository
public interface SolicitudBancariaRepository extends JpaRepository<SolicitudBancaria, Long> {
    // Puedes añadir métodos como findBySolicitudId(...) si lo necesitas
}