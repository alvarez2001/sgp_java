package com.diocesisdecarupano.sgp.modules.concept.domain.model;

import com.diocesisdecarupano.sgp.modules.concept.domain.enums.RequestCodeEnum;

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
public class ConceptModel {
    private Long id;
    private String description;
    private RequestCodeEnum requestCode;
}
