package com.diocesisdecarupano.sgp.modules.auditoria.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.auditoria.infrastructure.persistence.AuditoriaProyecto;

@Repository
public interface AuditoriaProyectoRepository extends JpaRepository<AuditoriaProyecto, Long> {
    // Puedes agregar métodos como List<AuditoriaProyecto> findByProyectoId(Long id);
}