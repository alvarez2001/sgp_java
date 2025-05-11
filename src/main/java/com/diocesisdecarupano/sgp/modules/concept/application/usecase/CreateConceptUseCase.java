package com.diocesisdecarupano.sgp.modules.concept.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptRequestDTO;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptResponseDTO;
import com.diocesisdecarupano.sgp.modules.concept.domain.model.ConceptModel;
import com.diocesisdecarupano.sgp.modules.concept.domain.port.ConceptRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class CreateConceptUseCase {

    @Autowired
    private ConceptRepositoryPort repository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public ConceptResponseDTO execute(ConceptRequestDTO request) {
        ConceptModel domain = modelMapper.map(request, ConceptModel.class);
        boolean existsDescription = repository.existsByDescription(domain.getDescription());

        if (existsDescription) {
            throw new BadRequestException("La descripción ya existe");
        }

        ConceptModel saved = repository.save(domain);

        return modelMapper.map(saved, ConceptResponseDTO.class);
    }

}
