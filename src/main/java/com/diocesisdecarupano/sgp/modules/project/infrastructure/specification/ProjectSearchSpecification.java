package com.diocesisdecarupano.sgp.modules.project.infrastructure.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectCurrency;
import com.diocesisdecarupano.sgp.modules.project.domain.enums.ProjectStatus;
import com.diocesisdecarupano.sgp.modules.project.infrastructure.entity.Project;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProjectSearchSpecification implements Specification<Project> {
    private ProjectSearchCriteriaDTO searchCriteriaDTO;

    private final EntityManager entityManager;

    public ProjectSearchSpecification(ProjectSearchCriteriaDTO searchCriteriaDTO, EntityManager entityManager) {
        this.searchCriteriaDTO = searchCriteriaDTO;
        this.entityManager = entityManager;
    }

    @Override
    public Predicate toPredicate(@SuppressWarnings("null") Root<Project> root, @Nullable CriteriaQuery<?> query,
            @SuppressWarnings("null") CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(this.searchCriteriaDTO.getCode())) {
            Predicate codeLike = criteriaBuilder.like(root.get("code"),
                    "%" + this.searchCriteriaDTO.getCode() + "%");

            predicates.add(codeLike);
        }

        if (StringUtils.hasText(this.searchCriteriaDTO.getName())) {
            Predicate codeLike = criteriaBuilder.like(root.get("name"),
                    "%" + this.searchCriteriaDTO.getName() + "%");

            predicates.add(codeLike);
        }

        if (StringUtils.hasText(this.searchCriteriaDTO.getAlias())) {
            Predicate codeLike = criteriaBuilder.like(root.get("alias"),
                    "%" + this.searchCriteriaDTO.getAlias() + "%");

            predicates.add(codeLike);
        }

        if (this.searchCriteriaDTO.getMinApproved() != null
                && this.searchCriteriaDTO.getMinApproved().floatValue() > 0) {
            Predicate minApproved = criteriaBuilder.greaterThanOrEqualTo(root.get("approved"),
                    this.searchCriteriaDTO.getMinApproved());
            predicates.add(minApproved);
        }

        if (this.searchCriteriaDTO.getMaxApproved() != null
                && this.searchCriteriaDTO.getMaxApproved().floatValue() > 0) {
            Predicate maxApproved = criteriaBuilder.lessThanOrEqualTo(root.get("approved"),
                    this.searchCriteriaDTO.getMaxApproved());
            predicates.add(maxApproved);
        }

        if (this.searchCriteriaDTO.getMinAvailable() != null
                && this.searchCriteriaDTO.getMinAvailable().floatValue() > 0) {
            Predicate minAvailable = criteriaBuilder.greaterThanOrEqualTo(root.get("available"),
                    this.searchCriteriaDTO.getMinAvailable());
            predicates.add(minAvailable);
        }

        if (this.searchCriteriaDTO.getMaxAvailable() != null
                && this.searchCriteriaDTO.getMaxAvailable().floatValue() > 0) {
            Predicate maxAvailable = criteriaBuilder.lessThanOrEqualTo(root.get("available"),
                    this.searchCriteriaDTO.getMaxAvailable());
            predicates.add(maxAvailable);
        }

        if (this.searchCriteriaDTO.getMinCommission() != null
                && this.searchCriteriaDTO.getMinCommission().floatValue() > 0) {
            Predicate minCommission = criteriaBuilder.greaterThanOrEqualTo(root.get("commission"),
                    this.searchCriteriaDTO.getMinCommission());
            predicates.add(minCommission);
        }

        if (this.searchCriteriaDTO.getMaxCommission() != null
                && this.searchCriteriaDTO.getMaxCommission().floatValue() > 0) {
            Predicate maxCommission = criteriaBuilder.lessThanOrEqualTo(root.get("commission"),
                    this.searchCriteriaDTO.getMaxCommission());
            predicates.add(maxCommission);
        }

        if (this.searchCriteriaDTO.getStatus() != null
                && this.searchCriteriaDTO.getStatus().length > 0) {
            In<ProjectStatus> requestCodeIn = criteriaBuilder.in(root.get("status"));
            for (ProjectStatus value : this.searchCriteriaDTO.getStatus()) {
                requestCodeIn.value(value);
            }

            predicates.add(requestCodeIn);
        }

        if (this.searchCriteriaDTO.getCurrencies() != null
                && this.searchCriteriaDTO.getCurrencies().length > 0) {
            In<ProjectCurrency> requestCodeIn = criteriaBuilder.in(root.get("currency"));
            for (ProjectCurrency value : this.searchCriteriaDTO.getCurrencies()) {
                requestCodeIn.value(value);
            }

            predicates.add(requestCodeIn);
        }

        if (this.searchCriteriaDTO.getUsersId() != null
                && this.searchCriteriaDTO.getUsersId().length > 0) {
            In<User> usersIn = criteriaBuilder.in(root.get("user"));
            for (Long value : this.searchCriteriaDTO.getUsersId()) {
                User userRef = entityManager.getReference(User.class, value);
                usersIn.value(userRef);
            }

            predicates.add(usersIn);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
