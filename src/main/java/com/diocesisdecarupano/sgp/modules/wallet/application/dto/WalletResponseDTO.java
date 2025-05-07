package com.diocesisdecarupano.sgp.modules.wallet.application.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletResponseDTO {
    private Long id;
    private Long userId;
    private String name;
    private String type;
    private String currency;
    private BigDecimal currentBalance;
}
