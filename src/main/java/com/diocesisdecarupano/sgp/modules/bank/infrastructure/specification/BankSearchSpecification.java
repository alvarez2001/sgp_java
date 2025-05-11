package com.diocesisdecarupano.sgp.modules.bank.infrastructure.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import com.diocesisdecarupano.sgp.modules.bank.application.dto.BankSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.bank.domain.enums.BankType;
import com.diocesisdecarupano.sgp.modules.bank.infrastructure.entity.Bank;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder.In;

public class BankSearchSpecification implements Specification<Bank> {

    private BankSearchCriteriaDTO bankSearchCriteriaDTO;

    public BankSearchSpecification(BankSearchCriteriaDTO bankSearchCriteriaDTO) {
        this.bankSearchCriteriaDTO = bankSearchCriteriaDTO;
    }

    @Override
    public Predicate toPredicate(@SuppressWarnings("null") Root<Bank> root, @Nullable CriteriaQuery<?> query, @SuppressWarnings("null") CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(this.bankSearchCriteriaDTO.getAccountHolder())) {
            Predicate accountHolderLike = criteriaBuilder.like(root.get("accountHolder"),
                    "%" + this.bankSearchCriteriaDTO.getAccountHolder() + "%");

            predicates.add(accountHolderLike);
        }

        if (StringUtils.hasText(this.bankSearchCriteriaDTO.getIdentification())) {
            Predicate identificationLike = criteriaBuilder.like(root.get("identification"),
                    "%" + this.bankSearchCriteriaDTO.getIdentification() + "%");

            predicates.add(identificationLike);
        }

        if (StringUtils.hasText(this.bankSearchCriteriaDTO.getBankName())) {
            Predicate bankNameLike = criteriaBuilder.like(root.get("bankName"),
                    "%" + this.bankSearchCriteriaDTO.getBankName() + "%");

            predicates.add(bankNameLike);
        }

        if (StringUtils.hasText(this.bankSearchCriteriaDTO.getAccountNumber())) {
            Predicate accountNumberLike = criteriaBuilder.like(root.get("accountNumber"),
                    "%" + this.bankSearchCriteriaDTO.getAccountNumber() + "%");

            predicates.add(accountNumberLike);
        }

        if (StringUtils.hasText(this.bankSearchCriteriaDTO.getAlias())) {
            Predicate aliasLike = criteriaBuilder.like(root.get("alias"),
                    "%" + this.bankSearchCriteriaDTO.getAlias() + "%");

            predicates.add(aliasLike);
        }

        if (this.bankSearchCriteriaDTO.getType() != null && this.bankSearchCriteriaDTO.getType().length > 0) {
            In<BankType> typeIn = criteriaBuilder.in(root.get("type"));
            for (BankType bankType : this.bankSearchCriteriaDTO.getType()) {
                typeIn.value(bankType);
            }

            predicates.add(typeIn);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
