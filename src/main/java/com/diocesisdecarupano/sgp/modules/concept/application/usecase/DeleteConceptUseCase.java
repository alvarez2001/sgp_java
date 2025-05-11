package com.diocesisdecarupano.sgp.modules.concept.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.concept.domain.model.ConceptModel;
import com.diocesisdecarupano.sgp.modules.concept.domain.port.ConceptRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class DeleteConceptUseCase {
    @Autowired
    private ConceptRepositoryPort repository;

    @Transactional
    public void execute(Long id) {

        ConceptModel existing = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Concept not found"));

        repository.deleteById(existing.getId());
    }
}
