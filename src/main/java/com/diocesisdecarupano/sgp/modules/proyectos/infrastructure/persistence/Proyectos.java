package com.diocesisdecarupano.sgp.modules.proyectos.infrastructure.persistence;

import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private Boolean aprobado;
    private Double disponible;
    private Double comision;
    private String status;
    private String alias;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;
}