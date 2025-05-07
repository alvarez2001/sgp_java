package com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.persistence.EgresosDirectos;

@Repository
public interface EgresosDirectosRepository extends JpaRepository<EgresosDirectos, Long> {
    // Puedes agregar métodos como List<EgresosDirectos> findByProyectoId(Long id);
}