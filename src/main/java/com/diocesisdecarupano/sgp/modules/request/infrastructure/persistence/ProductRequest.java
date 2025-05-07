package com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitud_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "cantidad", nullable = false, precision = 10, scale = 2)
    private BigDecimal quantity;

    @Column(name = "descripcion", nullable = false, length = 190)
    private String description;

    @Column(name = "precio", nullable = false, precision = 30, scale = 4)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Request request;
}