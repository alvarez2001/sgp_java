package com.diocesisdecarupano.sgp.modules.bancos.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diocesisdecarupano.sgp.modules.bancos.infrastructure.persistence.Bancos;

@Repository
public interface BancosRepository extends JpaRepository<Bancos, Long> {
    // Puedes agregar métodos personalizados aquí si los necesitas
}