package com.diocesisdecarupano.sgp.modules.concept.application.dto;

import com.diocesisdecarupano.sgp.modules.concept.domain.enums.RequestCodeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConceptSearchCriteriaDTO {

    private String description;
    private RequestCodeEnum [] requestCodes;

}
