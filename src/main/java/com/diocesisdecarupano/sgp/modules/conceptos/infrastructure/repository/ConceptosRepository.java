package com.diocesisdecarupano.sgp.modules.conceptos.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.conceptos.infrastructure.persistence.Conceptos;

@Repository
public interface ConceptosRepository extends JpaRepository<Conceptos, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}