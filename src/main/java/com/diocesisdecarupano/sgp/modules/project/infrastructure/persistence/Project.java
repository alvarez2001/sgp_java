package com.diocesisdecarupano.sgp.modules.project.infrastructure.persistence;

import java.math.BigDecimal;

import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "codigo", nullable = false, length = 50, unique = true)
    private String code;

    @Column(name = "nombre", nullable = false, length = 191)
    private String name;

    @Column(name = "aprobado", nullable = false, precision = 30, scale = 2)
    private BigDecimal approved;

    @Column(name = "disponible", nullable = false, precision = 30, scale = 2)
    private BigDecimal available;

    @Column(name = "comision", nullable = false, precision = 30, scale = 2)
    private BigDecimal commission;

    @Column(name = "status", nullable = false)
    private byte status;

    @Column(name = "moneda", nullable = false, length = 40)
    private String currency;

    @Column(name = "alias", length = 100)
    private String alias;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", columnDefinition = "BIGINT UNSIGNED")
    private User user;
}