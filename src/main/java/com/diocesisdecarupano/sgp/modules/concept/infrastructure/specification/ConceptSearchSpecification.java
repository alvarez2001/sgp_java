package com.diocesisdecarupano.sgp.modules.concept.infrastructure.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.concept.domain.enums.RequestCodeEnum;
import com.diocesisdecarupano.sgp.modules.concept.infrastructure.entity.Concept;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder.In;

public class ConceptSearchSpecification implements Specification<Concept> {

    private ConceptSearchCriteriaDTO conceptSearchCriteriaDTO;

    public ConceptSearchSpecification(ConceptSearchCriteriaDTO conceptSearchCriteriaDTO) {
        this.conceptSearchCriteriaDTO = conceptSearchCriteriaDTO;
    }

    @Override
    public Predicate toPredicate(@SuppressWarnings("null") Root<Concept> root, @Nullable CriteriaQuery<?> query,
            @SuppressWarnings("null") CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(this.conceptSearchCriteriaDTO.getDescription())) {
            Predicate descriptionLike = criteriaBuilder.like(root.get("description"),
                    "%" + this.conceptSearchCriteriaDTO.getDescription() + "%");

            predicates.add(descriptionLike);
        }

        if (this.conceptSearchCriteriaDTO.getRequestCodes() != null
                && this.conceptSearchCriteriaDTO.getRequestCodes().length > 0) {
            In<RequestCodeEnum> requestCodeIn = criteriaBuilder.in(root.get("requestCode"));
            for (RequestCodeEnum requestCodeEnum : this.conceptSearchCriteriaDTO.getRequestCodes()) {
                requestCodeIn.value(requestCodeEnum);
            }

            predicates.add(requestCodeIn);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
