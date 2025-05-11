package com.diocesisdecarupano.sgp.modules.concept.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptResponseDTO;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.concept.domain.port.ConceptRepositoryPort;

@Service
public class PaginateConceptUseCase {
    @Autowired
    private ConceptRepositoryPort repository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Page<ConceptResponseDTO> execute(ConceptSearchCriteriaDTO searchCriteriaDTO, Pageable pageable) {
        return repository.paginate(searchCriteriaDTO, pageable)
                .map(model -> modelMapper.map(model, ConceptResponseDTO.class));
    }
}
