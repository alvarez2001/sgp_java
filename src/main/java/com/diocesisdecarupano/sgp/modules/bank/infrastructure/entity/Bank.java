package com.diocesisdecarupano.sgp.modules.bank.infrastructure.entity;

import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bancos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "titular", nullable = false, length = 190)
    private String accountHolder;

    @Column(name = "identificacion", nullable = false, length = 255)
    private String identification;

    @Column(name = "entidad", nullable = false, length = 190)
    private String bankName;

    @Column(name = "numero", nullable = false, length = 40)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private BankType type;

    @Column(name = "alias", length = 100)
    private String alias;
}