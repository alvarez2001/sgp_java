package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitud_aprobaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudAprobaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean revisado;
    private Boolean autorizado;
    private Boolean ejecutado;
    private Boolean rechazado;

    @OneToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;
}