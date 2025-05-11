package com.diocesisdecarupano.sgp.modules.concept.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptResponseDTO;
import com.diocesisdecarupano.sgp.modules.concept.domain.model.ConceptModel;
import com.diocesisdecarupano.sgp.modules.concept.domain.port.ConceptRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class GetConceptUseCase {

    @Autowired
    private ConceptRepositoryPort repository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public ConceptResponseDTO execute(Long id) {

        ConceptModel concept = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Concept not found"));

        return modelMapper.map(concept, ConceptResponseDTO.class);
    }
}
