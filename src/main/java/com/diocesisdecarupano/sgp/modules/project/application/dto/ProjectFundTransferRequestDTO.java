package com.diocesisdecarupano.sgp.modules.project.application.dto;

import java.math.BigDecimal;

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
public class ProjectFundTransferRequestDTO {

    @NotNull(message = "El valor del monto no puede ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "El valor del monto debe ser al menos {value}")
    @Digits(integer = 28, fraction = 2, message = "El valor del monto no puede tener más de {integer} dígitos enteros y {fraction} decimales")
    private BigDecimal amount;

    @NotNull(message = "El valor comision no puede ser nulo")
    @DecimalMin(value = "0.00", inclusive = true, message = "El valor comision debe ser al menos {value}")
    @Digits(integer = 28, fraction = 2, message = "El valor comision no puede tener más de {integer} dígitos enteros y {fraction} decimales")
    private BigDecimal percentageComission;

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(max = 190, message = "La descripcion no puede exceder 190 caracteres")
    private String description;

}
