package com.diocesisdecarupano.sgp.modules.request.infrastructure.persistence;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitud_aprobaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "revisado", length = 190)
    private String reviewedBy;

    @Column(name = "autorizado", length = 190)
    private String authorizedBy;

    @Column(name = "ejecutado", length = 190)
    private String executedBy;

    @Column(name = "rechazado", length = 190)
    private String rejectedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Request request;
}