package com.diocesisdecarupano.sgp.modules.concept.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptRequestDTO;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptResponseDTO;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptUpdateRequestDTO;
import com.diocesisdecarupano.sgp.modules.concept.application.usecase.CreateConceptUseCase;
import com.diocesisdecarupano.sgp.modules.concept.application.usecase.DeleteConceptUseCase;
import com.diocesisdecarupano.sgp.modules.concept.application.usecase.GetConceptUseCase;
import com.diocesisdecarupano.sgp.modules.concept.application.usecase.PaginateConceptUseCase;
import com.diocesisdecarupano.sgp.modules.concept.application.usecase.UpdateConceptUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/concepts")
@Tag(name = "Concept", description = "Controller for Concept")
public class ConceptController {
    @Autowired
    private CreateConceptUseCase createUseCase;

    @Autowired
    private PaginateConceptUseCase paginateUseCase;

    @Autowired
    private GetConceptUseCase getUseCase;

    @Autowired
    private UpdateConceptUseCase updateUseCase;

    @Autowired
    private DeleteConceptUseCase deleteUseCase;

    @PostMapping
    public ResponseEntity<ConceptResponseDTO> create(
            @RequestBody @Validated ConceptRequestDTO request) {
        ConceptResponseDTO dto = createUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ConceptResponseDTO>> paginate(
            @Validated @ModelAttribute ConceptSearchCriteriaDTO criteria, Pageable pageable) {
        Page<ConceptResponseDTO> page = paginateUseCase.execute(criteria, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConceptResponseDTO> get(@PathVariable Long id) {
        ConceptResponseDTO dto = getUseCase.execute(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConceptResponseDTO> update(@PathVariable Long id,
            @RequestBody @Validated ConceptUpdateRequestDTO request) {
        ConceptResponseDTO dto = updateUseCase.execute(id, request);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
