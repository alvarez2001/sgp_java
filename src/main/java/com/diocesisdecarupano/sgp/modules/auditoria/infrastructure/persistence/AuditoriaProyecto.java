package com.diocesisdecarupano.sgp.modules.auditoria.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.proyectos.infrastructure.persistence.Proyectos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "auditoria_proyecto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditoriaProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean aprobado;
    private Double comision;
    private Double euro;
    private String descripcion;
    private String fullname;

    @Column(name = "solicitud_id")
    private Long solicitudId;

    @Column(name = "aprobado_antes")
    private Boolean aprobadoAntes;

    @Column(name = "comision_antes")
    private Double comisionAntes;

    @Column(name = "disponible_antes")
    private Double disponibleAntes;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyectos proyecto;
}