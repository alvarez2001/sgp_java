package com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.persistence.Ingresos;

@Repository
public interface IngresosRepository extends JpaRepository<Ingresos, Long> {
    // Puedes agregar consultas personalizadas si lo necesitas
}