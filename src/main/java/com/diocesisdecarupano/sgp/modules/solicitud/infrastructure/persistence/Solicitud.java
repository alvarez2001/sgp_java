package com.diocesisdecarupano.sgp.modules.solicitud.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.diocesisdecarupano.sgp.modules.proyectos.infrastructure.persistence.Proyectos;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responsable;
    private String status;
    private String concepto;
    private Double total;

    @Column(name = "tasa_cambio")
    private Double tasaCambio;

    private String monedaProductos;
    private String comprobante;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyectos proyecto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SolicitudProductos> productos;

    @OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private SolicitudBancaria banco;

    @OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private SolicitudAprobaciones aprobacion;
}