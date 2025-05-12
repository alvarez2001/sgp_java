package com.diocesisdecarupano.sgp.modules.project.application.usecase;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectResponseDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.model.ProjectModel;
import com.diocesisdecarupano.sgp.modules.project.domain.port.ProjectRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class CreateProjectUseCase {

    @Autowired
    private ProjectRepositoryPort repositoryPort;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public ProjectResponseDTO execute(ProjectRequestDTO request) {
        boolean existsCode = repositoryPort.existsByCode(request.getCode());
        if (existsCode) {
            throw new BadRequestException("La codigo ya existe");
        }
        ProjectModel projectModel = modelMapper.map(request, ProjectModel.class);

        BigDecimal commission = ProjectModel.calculateCommission(request.getApproved(),
                request.getPercentageComission());

        projectModel.addCommission(commission);

        projectModel.addAvailable(projectModel.getApproved());
        projectModel.subtractAvailable(projectModel.getCommission());

        ProjectModel saved = repositoryPort.save(projectModel);

        // add commission in project commission

        if (commission.compareTo(BigDecimal.ZERO) > 0) {
            ProjectModel projectCommissionModel = repositoryPort.findById(1L)
                    .orElseThrow(() -> new BadRequestException("Project Commission not found"));

            projectCommissionModel.addApproved(commission);
            projectCommissionModel.addAvailable(commission);
            repositoryPort.save(projectCommissionModel);
        }

        return modelMapper.map(saved, ProjectResponseDTO.class);
    }
}
