package com.diocesisdecarupano.sgp.modules.concept.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.concept.domain.model.ConceptModel;
import com.diocesisdecarupano.sgp.modules.concept.domain.port.ConceptRepositoryPort;
import com.diocesisdecarupano.sgp.modules.concept.infrastructure.entity.Concept;
import com.diocesisdecarupano.sgp.modules.concept.infrastructure.specification.ConceptSearchSpecification;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConceptRepositoryImpl implements ConceptRepositoryPort {

    @Autowired
    private final ConceptJpaRepository jpa;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ConceptModel save(ConceptModel model) {
        Concept domain = modelMapper.map(model, Concept.class);
        Concept saved = jpa.save(domain);
        ConceptModel concept = modelMapper.map(saved, ConceptModel.class);
        return concept;
    }

    @Override
    public Optional<ConceptModel> findById(Long id) {
        return jpa.findById(id).map(concept -> modelMapper.map(concept, ConceptModel.class));
    }

    @Override
    public List<ConceptModel> findAll() {
        return jpa.findAll()
                .stream()
                .map(concept -> modelMapper.map(concept, ConceptModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ConceptModel> paginate(ConceptSearchCriteriaDTO searchCriteriaDTO, Pageable pageable) {
        ConceptSearchSpecification searchSpecification = new ConceptSearchSpecification(searchCriteriaDTO);
        Page<Concept> entities = jpa.findAll(searchSpecification, pageable);
        return entities.map(entity -> modelMapper.map(entity, ConceptModel.class));
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public boolean existsByDescription(String description) {
        return jpa.existsByDescription(description);
    }

}
