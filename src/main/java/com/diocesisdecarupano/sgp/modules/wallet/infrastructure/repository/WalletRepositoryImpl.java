package com.diocesisdecarupano.sgp.modules.wallet.infrastructure.repository;

import com.diocesisdecarupano.sgp.modules.user.infrastructure.repository.UserRepository;
import com.diocesisdecarupano.sgp.modules.wallet.application.mapper.WalletMapper;
import com.diocesisdecarupano.sgp.modules.wallet.domain.model.Wallet;
import com.diocesisdecarupano.sgp.modules.wallet.domain.ports.WalletRepositoryPort;
import com.diocesisdecarupano.sgp.modules.wallet.infrastructure.persistence.WalletEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WalletRepositoryImpl implements WalletRepositoryPort {

    private final WalletJpaRepository jpa;
    private final UserRepository userJpa;

    @Override
    public Wallet save(Wallet domain) {
        // Validar existencia de usuario (opcional)
        var userRef = userJpa.getReferenceById(domain.getUserId());
        // Mapear dominio a entidad
        var entity = WalletMapper.toEntity(domain);
        // Asignar relación
        entity.setUser(userRef);
        // Persistir y mapear de vuelta a dominio
        var saved = jpa.save(entity);
        return WalletMapper.toDomain(saved);
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return jpa.findById(id)
                .map(WalletMapper::toDomain);
    }

    @Override
    public List<Wallet> findAllByUserId(Long userId) {
        return jpa.findAllByUserId(userId)
                .stream()
                .map(WalletMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        Optional<WalletEntity> wallet = jpa.findById(id);
        wallet.get().setState(false);
        jpa.save(wallet.get());
        // jpa.deleteById(id);
    }
}