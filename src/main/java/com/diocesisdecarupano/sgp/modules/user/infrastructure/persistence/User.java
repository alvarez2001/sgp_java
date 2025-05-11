package com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence;

import com.diocesisdecarupano.sgp.shared.infrastructure.persistence.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class User extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "nombres", nullable = false, length = 120)
    private String name;

    @Column(name = "apellidos", nullable = false, length = 120)
    private String lastName;

    @Column(name = "nacionalidad", nullable = false, length = 1)
    private String nationality;

    @Column(name = "cedula", nullable = false, length = 20)
    private String identification;

    @Column(name = "usuario", nullable = false, length = 30, unique = true)
    private String username;

    @Column(name = "email", nullable = false, length = 130)
    private String email;

    @Column(name = "password", nullable = false, length = 190)
    private String password;

    @Column(name = "status", nullable = false)
    private byte state;

    @Column(name = "tipo", nullable = false)
    private byte type;

    // Puedes agregar relaciones como roles o notificaciones si estás usando una
    // librería para eso
}