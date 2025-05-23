package com.diocesisdecarupano.sgp.modules.user.infrastructure.repository;

import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findAllByType(byte type);

    List<User> findAllByState(byte state);

}