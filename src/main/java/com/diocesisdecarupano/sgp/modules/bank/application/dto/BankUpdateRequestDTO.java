package com.diocesisdecarupano.sgp.modules.bank.application.dto;

import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankUpdateRequestDTO {

    @Size(max = 190, message = "El nombre del titular no puede exceder 190 caracteres")
    private String accountHolder;

    @Size(max = 20, message = "La identificación no puede exceder 20 caracteres")
    private String identification;

    @Size(max = 190, message = "El nombre del banco no puede exceder 190 caracteres")
    private String bankName;

    @Size(max = 40, message = "El número de cuenta no puede exceder 40 caracteres")
    private String accountNumber;

    private BankType type;

    @Size(max = 100, message = "El alias no puede exceder 100 caracteres")
    private String alias;

}
