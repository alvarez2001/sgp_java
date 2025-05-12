package com.diocesisdecarupano.sgp.modules.operation.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.project.infrastructure.entity.Project;
import com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence.Request;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "egresos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operacion_id", nullable = false, unique = true, columnDefinition = "BIGINT UNSIGNED")
    private Operation operation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", unique = true, columnDefinition = "BIGINT UNSIGNED")
    private Request request;
}