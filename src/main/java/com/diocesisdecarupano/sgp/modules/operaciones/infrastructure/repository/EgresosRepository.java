package com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.persistence.Egresos;

@Repository
public interface EgresosRepository extends JpaRepository<Egresos, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}