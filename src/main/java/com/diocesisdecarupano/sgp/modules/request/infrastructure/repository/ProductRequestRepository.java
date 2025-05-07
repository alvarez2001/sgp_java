package com.diocesisdecarupano.sgp.modules.request.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence.ProductRequest;

@Repository
public interface ProductRequestRepository extends JpaRepository<ProductRequest, Long> {
    // Ejemplo: List<SolicitudProductos> findBySolicitudId(Long solicitudId);
}