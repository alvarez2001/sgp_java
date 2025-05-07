package com.diocesisdecarupano.sgp.modules.bancos.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bancos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bancos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;
    private String identificacion;
    private String entidad;
    private String numero;
    private String alias;
    private String tipo;
}