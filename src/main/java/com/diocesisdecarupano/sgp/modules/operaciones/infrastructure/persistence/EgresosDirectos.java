package com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.proyectos.infrastructure.persistence.Proyectos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "egresos_directos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EgresosDirectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    @ManyToOne
    @JoinColumn(name = "operacion_id", nullable = false)
    private Operaciones operacion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyectos proyecto;
}