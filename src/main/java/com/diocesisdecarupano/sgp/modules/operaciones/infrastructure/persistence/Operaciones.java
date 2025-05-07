package com.diocesisdecarupano.sgp.modules.operaciones.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "operaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double tasa;
    private Double totalEuro;
    private Double comision;
    
    @Column(name = "total_solicitud")
    private Double totalSolicitud;

    private String concepto;
    private String referencia;
    private String banco;

    @Column(name = "fecha_bancaria")
    private LocalDate fechaBancaria;

    private String status;
}