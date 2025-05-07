package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitud_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private String descripcion;
    private Double precio;

    @Column(name = "solicitud_id")
    private Long solicitudId;

    // Si luego defines la entidad "Solicitud", puedes activar esta relación:
    @ManyToOne
    @JoinColumn(name = "solicitud_id", insertable = false, updatable = false)
    private Solicitud solicitud;
}