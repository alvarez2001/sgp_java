package com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String nacionalidad;
    private String cedula;
    private String usuario;
    private String email;

    @Column(nullable = false)
    private String password;

    private String status;
    private String tipo;

    // Puedes agregar relaciones como roles o notificaciones si estás usando una librería para eso
}
