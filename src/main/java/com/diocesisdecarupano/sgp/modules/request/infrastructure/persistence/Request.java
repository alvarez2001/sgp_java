package com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import com.diocesisdecarupano.sgp.modules.project.infrastructure.entity.Project;
import com.diocesisdecarupano.sgp.modules.request.domain.enums.ProductCurrency;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

@Entity
@Table(name = "solicituds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "responsable", nullable = false, length = 190)
    private String responsible;

    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Column(name = "concepto", nullable = false, length = 300)
    private String concept;

    @Column(name = "comprobante", length = 255)
    private String receipt;

    @Column(name = "total", nullable = false, precision = 30, scale = 4)
    private BigDecimal total;

    @Column(name = "tasa_cambio", precision = 30, scale = 4)
    private BigDecimal exchangeRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda_productos", nullable = false, length = 7)
    private ProductCurrency productCurrency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", columnDefinition = "BIGINT UNSIGNED")
    private User user;
}