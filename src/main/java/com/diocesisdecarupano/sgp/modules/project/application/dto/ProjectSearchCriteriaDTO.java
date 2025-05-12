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
public class ProjectSearchCriteriaDTO {
    private Long id;
    private String code;
    private String name;
    private BigDecimal minApproved;
    private BigDecimal maxApproved;
    private BigDecimal minAvailable;
    private BigDecimal maxAvailable;
    private BigDecimal minCommission;
    private BigDecimal maxCommission;
    private ProjectStatus[] status;
    private ProjectCurrency[] currencies;
    private String alias;
    private Long[] usersId;
}
