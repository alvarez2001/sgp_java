package com.diocesisdecarupano.sgp.modules.project.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diocesisdecarupano.sgp.modules.project.application.dto.FundsIncrementProjectRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectFundTransferRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectResponseDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectUpdateRequestDTO;
import com.diocesisdecarupano.sgp.modules.project.application.usecase.CreateProjectUseCase;
import com.diocesisdecarupano.sgp.modules.project.application.usecase.FundsIncrementProjectUseCase;
import com.diocesisdecarupano.sgp.modules.project.application.usecase.FundsTransferProjectUseCase;
import com.diocesisdecarupano.sgp.modules.project.application.usecase.GetProjectUseCase;
import com.diocesisdecarupano.sgp.modules.project.application.usecase.PaginateProjectUseCase;
import com.diocesisdecarupano.sgp.modules.project.application.usecase.UpdateProjectUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/projects")
@Tag(name = "Project", description = "Controller for Project")
public class ProjectController {
    @Autowired
    private CreateProjectUseCase createProjectUseCase;

    @Autowired
    private FundsIncrementProjectUseCase fundsIncrementProjectUseCase;

    @Autowired
    private FundsTransferProjectUseCase fundsTransferProjectUseCase;

    @Autowired
    private GetProjectUseCase getProjectUseCase;

    @Autowired
    private PaginateProjectUseCase paginateProjectUseCase;

    @Autowired
    private UpdateProjectUseCase updateProjectUseCase;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> create(@RequestBody @Validated ProjectRequestDTO request) {
        ProjectResponseDTO dto = createProjectUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponseDTO>> paginate(
            @Validated @ModelAttribute ProjectSearchCriteriaDTO criteria, Pageable pageable) {
        Page<ProjectResponseDTO> page = paginateProjectUseCase.execute(criteria, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> get(@PathVariable Long id) {
        ProjectResponseDTO dto = getProjectUseCase.execute(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> update(@PathVariable Long id,
            @RequestBody @Validated ProjectUpdateRequestDTO request) {
        ProjectResponseDTO dto = updateProjectUseCase.execute(id, request);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}/increment")
    public ResponseEntity<ProjectResponseDTO> increment(
            @PathVariable Long id,
            @RequestBody @Validated FundsIncrementProjectRequestDTO request) {
        ProjectResponseDTO dto = fundsIncrementProjectUseCase.execute(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/{fromId}/transfer/{toId}")
    public ResponseEntity<ProjectResponseDTO> increment(
            @PathVariable Long fromId,
            @PathVariable Long toId,
            @RequestBody @Validated ProjectFundTransferRequestDTO request) {
        ProjectResponseDTO dto = fundsTransferProjectUseCase.execute(request, fromId, toId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
