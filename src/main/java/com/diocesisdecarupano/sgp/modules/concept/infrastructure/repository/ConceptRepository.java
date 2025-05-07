package com.diocesisdecarupano.sgp.modules.concept.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.concept.infrastructure.persistence.Concept;

@Repository
public interface ConceptRepository extends JpaRepository<Concept, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}