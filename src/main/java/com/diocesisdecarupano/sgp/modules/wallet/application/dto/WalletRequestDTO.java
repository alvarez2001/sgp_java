package com.diocesisdecarupano.sgp.modules.wallet.application.dto;

import java.math.BigDecimal;

import com.diocesisdecarupano.sgp.modules.wallet.domain.enums.Currency;
import com.diocesisdecarupano.sgp.modules.wallet.domain.enums.WalletType;

import lombok.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Type is required")
    private WalletType type;

    @NotNull(message = "Currency is required")
    private Currency currency;

    @NotNull(message = "Initial balance is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Initial balance must be non-negative")
    private BigDecimal initialBalance;
}
