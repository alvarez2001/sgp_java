package com.diocesisdecarupano.sgp.modules.project.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.project.infrastructure.persistence.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Métodos personalizados si los necesitas
}