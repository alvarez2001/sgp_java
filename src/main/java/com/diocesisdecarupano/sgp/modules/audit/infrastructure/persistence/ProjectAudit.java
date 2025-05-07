package com.diocesisdecarupano.sgp.modules.audit.infrastructure.persistence;

import java.math.BigDecimal;

import com.diocesisdecarupano.sgp.modules.project.infrastructure.persistence.Project;
import com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence.Request;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "auditoria_proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "aprobado", precision = 30, scale = 2)
    private BigDecimal approved;

    @Column(name = "comision", precision = 30, scale = 2)
    private BigDecimal commission;

    @Column(name = "euro", precision = 30, scale = 2)
    private BigDecimal euroAmount;

    @Column(name = "aprobado_antes", precision = 30, scale = 2)
    private BigDecimal approvedBefore;

    @Column(name = "comision_antes", precision = 30, scale = 2)
    private BigDecimal commissionBefore;

    @Column(name = "disponible_antes", precision = 30, scale = 2)
    private BigDecimal availableBefore;

    @Column(name = "descripcion", nullable = false, length = 190)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", columnDefinition = "BIGINT UNSIGNED")
    private Request request;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id", columnDefinition = "BIGINT UNSIGNED")
    private Project project;

    @Column(name = "fullname", nullable = false, length = 190)
    private String fullName;
}