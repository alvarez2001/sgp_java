package com.diocesisdecarupano.sgp.modules.conceptos.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "conceptos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conceptos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String solicitud;
}