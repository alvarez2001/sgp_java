package com.diocesisdecarupano.sgp.modules.operation.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "operaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "tasa", nullable = false, precision = 30, scale = 4)
    private BigDecimal rate;

    @Column(name = "total_euro", nullable = false, precision = 30, scale = 2)
    private BigDecimal totalEuro;

    @Column(name = "comision", precision = 30, scale = 4)
    private BigDecimal commission;

    @Column(name = "total_solicitud", nullable = false, precision = 30, scale = 4)
    private BigDecimal totalRequest;

    @Column(name = "concepto", nullable = false, length = 190)
    private String concept;

    @Column(name = "referencia", nullable = false, length = 100)
    private String reference;

    @Column(name = "banco", length = 190)
    private String bank;

    @Column(name = "fecha_bancaria", nullable = false)
    private LocalDate bankDate;

    @Column(name = "status", nullable = false, length = 1)
    private String status;
}