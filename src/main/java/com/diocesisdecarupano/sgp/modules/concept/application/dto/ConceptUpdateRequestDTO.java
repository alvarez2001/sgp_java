package com.diocesisdecarupano.sgp.modules.concept.application.dto;

import com.diocesisdecarupano.sgp.modules.concept.domain.enums.RequestCodeEnum;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConceptUpdateRequestDTO {

    @Size(max = 255, message = "La descripcion no puede exceder 255 caracteres")
    private String description;

    private RequestCodeEnum requestCode;

}
