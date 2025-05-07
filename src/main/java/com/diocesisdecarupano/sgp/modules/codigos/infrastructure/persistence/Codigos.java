package com.diocesisdecarupano.sgp.modules.codigos.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "codigos_generados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Codigos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String motivo;
    private String fullname;

    private Boolean activo;
}
