package com.diocesisdecarupano.sgp.modules.project.application.usecase;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectFundTransferRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectResponseDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.model.ProjectModel;
import com.diocesisdecarupano.sgp.modules.project.domain.port.ProjectRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class FundsTransferProjectUseCase {

	@Autowired
	private ProjectRepositoryPort repositoryPort;

	private final ModelMapper modelMapper = new ModelMapper();

	@Transactional
	public ProjectResponseDTO execute(ProjectFundTransferRequestDTO request, Long fromId, Long toId) {
		ProjectModel projectModelFrom = repositoryPort.findById(fromId)
				.orElseThrow(() -> new BadRequestException("Desde donde no se ha encontrado"));

		ProjectModel projectModelTo = repositoryPort.findById(toId)
				.orElseThrow(() -> new BadRequestException("Hasta donde no se ha encontrado"));

		BigDecimal commission = ProjectModel.calculateCommission(request.getAmount(),
				request.getPercentageComission());

		if (commission.compareTo(BigDecimal.ZERO) > 0) {
			ProjectModel projectCommissionModel = repositoryPort.findById(1L)
					.orElseThrow(() -> new BadRequestException("Project Commission not found"));

			projectCommissionModel.addApproved(commission);
			projectCommissionModel.addAvailable(commission);
			repositoryPort.save(projectCommissionModel);
		}

		projectModelFrom.subtractApproved(request.getAmount());
		projectModelFrom.subtractAvailable(request.getAmount());

		projectModelTo.addApproved(request.getAmount());
		projectModelTo.addAvailable(request.getAmount());
		projectModelTo.subtractAvailable(commission);
		projectModelTo.addCommission(commission);

		repositoryPort.save(projectModelFrom);
		ProjectModel saved = repositoryPort.save(projectModelTo);

		return modelMapper.map(saved, ProjectResponseDTO.class);
	}

}
