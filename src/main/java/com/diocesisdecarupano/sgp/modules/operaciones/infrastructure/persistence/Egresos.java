package com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.proyectos.infrastructure.persistence.Proyectos;
import com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence.Solicitud;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "egresos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Egresos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operacion_id", nullable = false)
    private Operaciones operacion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyectos proyecto;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;
}