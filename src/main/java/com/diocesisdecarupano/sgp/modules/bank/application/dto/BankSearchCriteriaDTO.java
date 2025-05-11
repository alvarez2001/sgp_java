package com.diocesisdecarupano.sgp.modules.bank.application.dto;

import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankSearchCriteriaDTO {

    private String accountHolder;
    private String identification;
    private String bankName;
    private String accountNumber;
    private BankType [] type;
    private String alias;

}
