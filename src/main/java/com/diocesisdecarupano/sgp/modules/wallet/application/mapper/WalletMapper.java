package com.diocesisdecarupano.sgp.modules.wallet.application.mapper;

import com.diocesisdecarupano.sgp.modules.wallet.domain.model.Wallet;
import com.diocesisdecarupano.sgp.modules.wallet.infrastructure.persistence.WalletEntity;

public class WalletMapper {
    
    public static WalletEntity toEntity(Wallet domain) {
        return WalletEntity.builder()
            .id(domain.getId())
            // user se setea luego en el repositorio para aprovechar getReferenceById
            .name(domain.getName())
            .type(domain.getType())
            .currency(domain.getCurrency())
            .currentBalance(domain.getCurrentBalance())
            .state(domain.isState())
            .build();
    }

    public static Wallet toDomain(WalletEntity entity) {
        return Wallet.builder()
            .id(entity.getId())
            .userId(entity.getUser().getId())
            .name(entity.getName())
            .type(entity.getType())
            .currency(entity.getCurrency())
            .currentBalance(entity.getCurrentBalance())
            .state(entity.isState())
            .build();
    }
}
