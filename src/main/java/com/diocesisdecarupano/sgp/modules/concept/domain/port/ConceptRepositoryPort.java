package com.diocesisdecarupano.sgp.modules.concept.domain.port;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diocesisdecarupano.sgp.modules.concept.application.dto.ConceptSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.concept.domain.model.ConceptModel;

public interface ConceptRepositoryPort {

    ConceptModel save(ConceptModel model);

    Optional<ConceptModel> findById(Long id);

    List<ConceptModel> findAll();

    Page<ConceptModel> paginate(ConceptSearchCriteriaDTO searchCriteriaDTO, Pageable pageable);

    void deleteById(Long id);

    boolean existsByDescription(String description);
}
