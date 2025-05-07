package com.diocesisdecarupano.sgp.modules.user.domain.repository;

import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    List<User> findAll();

    List<User> findAllByType(byte type);

    List<User> findAllByState(byte state);

    List<User> findByNameContaining(String name);

    User save(User user);

    void deleteById(Long id);
}
