package com.diocesisdecarupano.sgp.modules.project.application.dto;

import java.math.BigDecimal;

import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectCurrency;
import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectStatus;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDTO {

    @NotBlank(message = "El codigo es obligatoria")
    @Size(max = 50, message = "El codigo no puede exceder 50 caracteres")
    private String code;

    @NotBlank(message = "El nombre es obligatoria")
    @Size(max = 191, message = "El nombre no puede exceder 50 caracteres")
    private String name;

    @NotNull(message = "El valor aprobado no puede ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "El valor aprobado debe ser al menos {value}")
    @Digits(integer = 28, fraction = 2, message = "El valor aprobado no puede tener más de {integer} dígitos enteros y {fraction} decimales")
    private BigDecimal approved;

    @NotNull(message = "El valor comision no puede ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "El valor comision debe ser al menos {value}")
    @Digits(integer = 28, fraction = 2, message = "El valor comision no puede tener más de {integer} dígitos enteros y {fraction} decimales")
    private BigDecimal percentageComission;

    @NotNull(message = "El estatus es obligatoria")
    private ProjectStatus status;

    @NotNull(message = "La moneda es obligatoria")
    private ProjectCurrency currency;

    @Size(max = 100, message = "El alias no puede exceder 100 caracteres")
    private String alias;

    private Long userId;
}
