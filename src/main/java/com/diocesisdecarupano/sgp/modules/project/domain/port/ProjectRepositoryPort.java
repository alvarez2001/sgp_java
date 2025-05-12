package com.diocesisdecarupano.sgp.modules.project.domain.port;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.model.ProjectModel;


public interface ProjectRepositoryPort {

    ProjectModel save(ProjectModel model);

    Optional<ProjectModel> findById(Long id);

    List<ProjectModel> findAll();

    Page<ProjectModel> paginate(ProjectSearchCriteriaDTO searchCriteriaDTO, Pageable pageable);

    void deleteById(Long id);

    boolean existsByCode(String code);
}
