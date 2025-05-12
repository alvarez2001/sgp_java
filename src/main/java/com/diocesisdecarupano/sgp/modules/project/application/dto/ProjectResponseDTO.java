package com.diocesisdecarupano.sgp.modules.project.application.dto;

import java.math.BigDecimal;

import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectCurrency;
import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponseDTO {
    private Long id;
    private String code;
    private String name;
    private BigDecimal approved;
    private BigDecimal available;
    private BigDecimal commission;
    // private BigDecimal percentageComission;
    private ProjectStatus status;
    private ProjectCurrency currency;
    private String alias;
    private Long userId;
}
