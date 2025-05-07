package com.diocesisdecarupano.sgp.modules.wallet.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import com.diocesisdecarupano.sgp.modules.wallet.domain.enums.Currency;
import com.diocesisdecarupano.sgp.modules.wallet.domain.enums.WalletType;

@Getter
@Builder
@EqualsAndHashCode
public class Wallet {
    private final Long id;
    private final Long userId;
    private final String name;
    private final WalletType type;
    private final Currency currency;
    private final boolean state;
    private BigDecimal currentBalance;

    // lógica de dominio si la necesitas, por ejemplo:
    public void deposit(BigDecimal amount) {
        if (amount.signum() <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        currentBalance = currentBalance.add(amount);
        // si quieres inmutabilidad pura devuelve una nueva instancia en lugar de mutar
    }

    public void withdraw(BigDecimal amount) {
        if (amount.signum() <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        if (currentBalance.compareTo(amount) < 0)
            throw new IllegalStateException("Insufficient funds");
        currentBalance = currentBalance.subtract(amount);
    }
}