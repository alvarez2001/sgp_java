package com.diocesisdecarupano.sgp.modules.wallet.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diocesisdecarupano.sgp.modules.wallet.infrastructure.persistence.WalletEntity;

import java.util.List;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {
    List<WalletEntity> findAllByUserId(Long userId);
}