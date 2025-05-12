package com.diocesisdecarupano.sgp.modules.project.application.dto;

import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectCurrency;
import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectStatus;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectUpdateRequestDTO {

    @Size(max = 50, message = "El codigo no puede exceder 50 caracteres")
    private String code;

    @Size(max = 191, message = "El nombre no puede exceder 50 caracteres")
    private String name;

    private ProjectStatus status;

    private ProjectCurrency currency;

    @Size(max = 100, message = "El alias no puede exceder 100 caracteres")
    private String alias;

    private Long userId;

}
