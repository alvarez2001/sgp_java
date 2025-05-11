package com.diocesisdecarupano.sgp.modules.concept.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.concept.infrastructure.entity.Concept;

@Repository
public interface ConceptJpaRepository extends JpaRepository<Concept, Long>, JpaSpecificationExecutor<Concept> {
    boolean existsByDescription(String description);
}