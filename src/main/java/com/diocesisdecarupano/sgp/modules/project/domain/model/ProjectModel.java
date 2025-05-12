package com.diocesisdecarupano.sgp.modules.project.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectCurrency;
import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {
    private Long id;
    private String code;
    private String name;
    private BigDecimal approved = BigDecimal.valueOf(0);
    private BigDecimal available = BigDecimal.valueOf(0);
    private BigDecimal commission = BigDecimal.valueOf(0);
    private ProjectStatus status;
    private ProjectCurrency currency;
    private String alias;
    private Long userId;

    public static BigDecimal calculateCommission(BigDecimal amount, BigDecimal percentageCommission) {
        // 1) Multiplica amount × percentageCommission
        BigDecimal raw = amount.multiply(percentageCommission);
        // 2) Divide entre 100 con escala y modo de redondeo
        return raw
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public void addApproved(BigDecimal amount) {
        BigDecimal approvedAmount = this.getApproved().add(amount);
        this.setApproved(approvedAmount);
    }

    public void addAvailable(BigDecimal amount) {
        BigDecimal availableAmount = this.getAvailable().add(amount);
        this.setAvailable(availableAmount);
    }

    public void addCommission(BigDecimal amount) {
        BigDecimal commissionAmount = this.getCommission().add(amount);
        this.setCommission(commissionAmount);
    }

    public void subtractApproved(BigDecimal amount) {
        BigDecimal approvedAmount = this.getApproved().subtract(amount);
        this.setApproved(approvedAmount);
    }

    public void subtractAvailable(BigDecimal amount) {
        BigDecimal availableAmount = this.getAvailable().subtract(amount);
        this.setAvailable(availableAmount);
    }

    public void subtractCommission(BigDecimal amount) {
        BigDecimal commissionAmount = this.getCommission().subtract(amount);
        this.setCommission(commissionAmount);
    }
}
