package com.diocesisdecarupano.sgp.modules.bank.domain.model;

import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class BankModel {
    private Long id;
    private String accountHolder;
    private String identification;
    private String bankName;
    private String accountNumber;
    private BankType type;
    private String alias;

}
