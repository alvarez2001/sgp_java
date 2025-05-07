package com.diocesisdecarupano.sgp.modules.code.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.code.infrastructure.persistence.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {
}