package com.diocesisdecarupano.sgp.modules.project.application.usecase;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diocesisdecarupano.sgp.modules.project.application.dto.FundsIncrementProjectRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectResponseDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.model.ProjectModel;
import com.diocesisdecarupano.sgp.modules.project.domain.port.ProjectRepositoryPort;
import com.diocesisdecarupano.sgp.shared.infrastructure.exception.BadRequestException;

@Service
public class FundsIncrementProjectUseCase {

	@Autowired
	private ProjectRepositoryPort repositoryPort;

	private final ModelMapper modelMapper = new ModelMapper();

	@Transactional
	public ProjectResponseDTO execute(Long id, FundsIncrementProjectRequestDTO request) {
		if (id == 1L) {
			throw new BadRequestException("No puedes aumentar el proyecto comision");
		}
		ProjectModel projectModel = repositoryPort.findById(id)
				.orElseThrow(() -> new BadRequestException("No se ha encontrado el proyecto"));

		BigDecimal commission = ProjectModel.calculateCommission(request.getAmount(),
				request.getPercentageComission());

		if (commission.compareTo(BigDecimal.ZERO) > 0) {
			ProjectModel projectCommissionModel = repositoryPort.findById(1L)
					.orElseThrow(() -> new BadRequestException("No se ha encontrado el proyecto comision"));

			projectCommissionModel.addApproved(commission);
			projectCommissionModel.addAvailable(commission);
			repositoryPort.save(projectCommissionModel);
		}

		projectModel.addApproved(request.getAmount());
		projectModel.addAvailable(request.getAmount());
		projectModel.subtractAvailable(commission);
		projectModel.addCommission(commission);

		ProjectModel saved = repositoryPort.save(projectModel);

		return modelMapper.map(saved, ProjectResponseDTO.class);
	}

}
