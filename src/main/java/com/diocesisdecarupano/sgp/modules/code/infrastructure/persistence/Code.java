package com.diocesisdecarupano.sgp.modules.code.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "codigos_generados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "codigo", nullable = false, length = 100)
    private String code;

    @Column(name = "motivo", length = 190)
    private String reason;

    @Column(name = "fullname", nullable = false, length = 255)
    private String fullName;

    @Column(name = "activo", nullable = false)
    private byte active;
}
