package com.diocesisdecarupano.sgp.modules.project.application.usecase;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectResponseDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectUpdateRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.model.ProjectModel;
import com.diocesisdecarupano.sgp.modules.project.domain.port.ProjectRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class UpdateProjectUseCase {
    @Autowired
    private ProjectRepositoryPort repositoryPort;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public ProjectResponseDTO execute(Long id, ProjectUpdateRequestDTO request) {
        ProjectModel projectModel = repositoryPort.findById(id)
                .orElseThrow(() -> new BadRequestException("Project not found"));

        if (StringUtils.hasText(request.getCode())) {
            boolean existsCode = repositoryPort.existsByCode(request.getCode());
            if (existsCode) {
                throw new BadRequestException("La codigo ya existe");
            }
            projectModel.setCode(request.getCode());
        }

        if (StringUtils.hasText(request.getAlias())) {
            projectModel.setAlias(request.getAlias());
        }

        if (StringUtils.hasText(request.getName())) {
            projectModel.setName(request.getName());
        }

        if (request.getCurrency() != null) {
            projectModel.setCurrency(request.getCurrency());
        }

        if (request.getStatus() != null) {
            projectModel.setStatus(request.getStatus());
        }

        projectModel.setUserId(request.getUserId());

        ProjectModel saved = repositoryPort.save(projectModel);
        return modelMapper.map(saved, ProjectResponseDTO.class);
    }
}
