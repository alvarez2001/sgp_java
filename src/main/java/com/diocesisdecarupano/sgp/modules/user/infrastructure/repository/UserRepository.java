package com.diocesisdecarupano.sgp.modules.user.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);

    Optional<User> findByUsuario(String usuario);

    boolean existsByEmail(String email);
}