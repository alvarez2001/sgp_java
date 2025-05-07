package com.diocesisdecarupano.sgp.modules.request.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence.RequestApproval;

@Repository
public interface RequestApprovalRepository extends JpaRepository<RequestApproval, Long> {
    // Puedes agregar métodos como: Optional<SolicitudAprobaciones> findBySolicitudId(Long id);
}