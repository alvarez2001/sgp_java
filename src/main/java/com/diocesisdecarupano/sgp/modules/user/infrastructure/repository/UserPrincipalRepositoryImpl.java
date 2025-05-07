package com.diocesisdecarupano.sgp.modules.user.infrastructure.repository;

import com.diocesisdecarupano.sgp.modules.user.domain.enums.StateUser;
import com.diocesisdecarupano.sgp.modules.user.domain.repository.UserRepositoryPort;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserPrincipalRepositoryImpl implements UserRepositoryPort {

    private final UserRepository userRepository;

    public UserPrincipalRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public List<User> findByNameContaining(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        Optional<User> userOpt = findById(id);
        if(!userOpt.isEmpty()) {
            User user = userOpt.get();
            user.setState(StateUser.INACTIVE.getCode());
            userRepository.save(user);
        }
    }

    public List<User> findAllByType(byte type) {
        return userRepository.findAllByType(type);
    }

    public List<User> findAllByState(byte state) {
        return userRepository.findAllByState(state);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
