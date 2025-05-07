package com.diocesisdecarupano.sgp.modules.proyectos.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.proyectos.infrastructure.persistence.Proyectos;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Long> {
    // Métodos personalizados si los necesitas
}