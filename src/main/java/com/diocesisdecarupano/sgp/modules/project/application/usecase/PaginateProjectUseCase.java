package com.diocesisdecarupano.sgp.modules.project.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectResponseDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.port.ProjectRepositoryPort;

@Service
public class PaginateProjectUseCase {

    @Autowired
    private ProjectRepositoryPort repositoryPort;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public Page<ProjectResponseDTO> execute(ProjectSearchCriteriaDTO searchCriteriaDTO, Pageable pageable) {
        return repositoryPort.paginate(searchCriteriaDTO, pageable)
                .map(model -> modelMapper.map(model, ProjectResponseDTO.class));
    }
}
