package com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitud_bancarias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "titular", nullable = false, length = 190)
    private String accountHolder;

    @Column(name = "identificacion", nullable = false, length = 190)
    private String identification;

    @Column(name = "banco", nullable = false, length = 190)
    private String bankName;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 15)
    private BankType type;

    @Column(name = "numero", nullable = false, length = 190)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Request request;
}