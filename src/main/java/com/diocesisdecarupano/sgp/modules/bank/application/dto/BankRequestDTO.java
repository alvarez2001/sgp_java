package com.diocesisdecarupano.sgp.modules.bank.application.dto;

import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;

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
public class BankRequestDTO {

    @NotBlank(message = "El titular de la cuenta es obligatorio")
    @Size(max = 190, message = "El nombre del titular no puede exceder 190 caracteres")
    private String accountHolder;

    @NotBlank(message = "La identificación es obligatoria")
    @Size(max = 20, message = "La identificación no puede exceder 20 caracteres")
    private String identification;

    @NotBlank(message = "El nombre del banco es obligatorio")
    @Size(max = 190, message = "El nombre del banco no puede exceder 190 caracteres")
    private String bankName;

    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(max = 40, message = "El número de cuenta no puede exceder 40 caracteres")
    private String accountNumber;

    @NotNull(message = "El tipo de cuenta bancaria es obligatorio")
    private BankType type;

    @Size(max = 100, message = "El alias no puede exceder 100 caracteres")
    private String alias;

}
