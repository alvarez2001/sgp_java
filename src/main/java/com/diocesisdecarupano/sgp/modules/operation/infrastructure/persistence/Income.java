package com.diocesisdecarupano.sgp.modules.operation.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.project.infrastructure.persistence.Project;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingresos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Income {

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
}