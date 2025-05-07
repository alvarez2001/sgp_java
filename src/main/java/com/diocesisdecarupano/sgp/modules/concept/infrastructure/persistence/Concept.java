package com.diocesisdecarupano.sgp.modules.concept.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "conceptos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Concept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 255, unique = true)
    private String description;

    /**
     * Solicitud code (2 characters)
     */
    @Column(name = "solicitud", nullable = false, length = 2)
    private String requestCode;
}