package com.diocesisdecarupano.sgp.modules.audit.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.audit.infrastructure.persistence.ProjectAudit;

@Repository
public interface ProjectAuditRepository extends JpaRepository<ProjectAudit, Long> {
    // Puedes agregar métodos como List<AuditoriaProyecto> findByProyectoId(Long id);
}