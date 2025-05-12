package com.diocesisdecarupano.sgp.modules.project.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.project.infrastructure.entity.Project;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {
    boolean existsByCode(String code);
}