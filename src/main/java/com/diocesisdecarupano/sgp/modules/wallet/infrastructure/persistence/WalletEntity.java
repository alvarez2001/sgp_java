package com.diocesisdecarupano.sgp.modules.wallet.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import com.diocesisdecarupano.sgp.modules.wallet.domain.enums.Currency;
import com.diocesisdecarupano.sgp.modules.wallet.domain.enums.WalletType;
import com.diocesisdecarupano.sgp.shared.infrastructure.persistence.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class WalletEntity extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private User user;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WalletType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    @Column(name = "current_balance", nullable = false)
    private BigDecimal currentBalance;

    @Column(name = "state", nullable = false)
    private boolean state;
}
