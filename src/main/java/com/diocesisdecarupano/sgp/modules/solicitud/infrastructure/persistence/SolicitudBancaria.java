package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitud_bancaria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;
    private String identificacion;
    private String banco;
    private String numero;
    private String tipo;

    @Column(name = "solicitud_id")
    private Long solicitudId;

    // Si más adelante defines una entidad Solicitud y deseas establecer la relación:
    @ManyToOne
    @JoinColumn(name = "solicitud_id", insertable = false, updatable = false)
    private Solicitud solicitud;
}