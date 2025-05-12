package com.diocesisdecarupano.sgp.modules.project.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectResponseDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.model.ProjectModel;
import com.diocesisdecarupano.sgp.modules.project.domain.port.ProjectRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class GetProjectUseCase {

    @Autowired
    private ProjectRepositoryPort repositoryPort;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public ProjectResponseDTO execute(Long id) {
        ProjectModel projectModel = repositoryPort.findById(id)
                .orElseThrow(() -> new BadRequestException("Project not found"));

        return modelMapper.map(projectModel, ProjectResponseDTO.class);
    }
}
