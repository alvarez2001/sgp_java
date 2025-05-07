package com.diocesisdecarupano.sgp.modules.request.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence.BankRequest;

@Repository
public interface BankRequestRepository extends JpaRepository<BankRequest, Long> {
    // Puedes añadir métodos como findBySolicitudId(...) si lo necesitas
}