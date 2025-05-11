package com.diocesisdecarupano.sgp.modules.concept.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptResponseDTO;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptUpdateRequestDTO;
import com.diocesisdecarupano.sgp.modules.concept.domain.model.ConceptModel;
import com.diocesisdecarupano.sgp.modules.concept.domain.port.ConceptRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class UpdateConceptUseCase {
    @Autowired
    private ConceptRepositoryPort repository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public ConceptResponseDTO execute(Long id, ConceptUpdateRequestDTO request) {
        ConceptModel existing = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Concept not found"));

        if (request.getRequestCode() != null) {
            existing.setRequestCode(request.getRequestCode());
        }

        if (StringUtils.hasText(request.getDescription())) {
            existing.setDescription(request.getDescription());

            boolean existsDescription = repository.existsByDescription(existing.getDescription());

            if (existsDescription) {
                throw new BadRequestException("La descripción ya existe");
            }
        }

        existing = repository.save(existing);
        return modelMapper.map(existing, ConceptResponseDTO.class);
    }
}
