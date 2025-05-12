package com.diocesisdecarupano.sgp.modules.project.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.diocesisdecarupano.sgp.modules.project.application.dto.ProjectSearchCriteriaDTO;
import com.diocesisdecarupano.sgp.modules.project.domain.model.ProjectModel;
import com.diocesisdecarupano.sgp.modules.project.domain.port.ProjectRepositoryPort;
import com.diocesisdecarupano.sgp.modules.project.infrastructure.entity.Project;
import com.diocesisdecarupano.sgp.modules.project.infrastructure.specification.ProjectSearchSpecification;
import com.diocesisdecarupano.sgp.modules.user.infrastructure.persistence.User;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepositoryPort {

    @Autowired
    private final ProjectJpaRepository jpa;

    @Autowired
    private final EntityManager entityManager;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProjectModel save(ProjectModel model) {
        Project domain = modelMapper.map(model, Project.class);
        if (model.getUserId() != null) {
            User userRef = entityManager.getReference(User.class, model.getUserId());
            domain.setUser(userRef);
        }
        Project saved = jpa.save(domain);
        ProjectModel project = modelMapper.map(saved, ProjectModel.class);
        if (saved.getUser() != null) {
            project.setUserId(saved.getUser().getId());
        }
        return project;
    }

    @Override
    public Optional<ProjectModel> findById(Long id) {
        return jpa.findById(id).map(project -> {
            ProjectModel projectModel = modelMapper.map(project, ProjectModel.class);
            if (project.getUser() != null) {
                projectModel.setUserId(project.getUser().getId());
            }
            return projectModel;
        });
    }

    @Override
    public List<ProjectModel> findAll() {
        return jpa.findAll()
                .stream()
                .map(project -> {
                    ProjectModel projectModel = modelMapper.map(project, ProjectModel.class);
                    if (project.getUser() != null) {
                        projectModel.setUserId(project.getUser().getId());
                    }
                    return projectModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProjectModel> paginate(ProjectSearchCriteriaDTO searchCriteriaDTO, Pageable pageable) {
        ProjectSearchSpecification searchSpecification = new ProjectSearchSpecification(searchCriteriaDTO,
                entityManager);
        Page<Project> entities = jpa.findAll(searchSpecification, pageable);
        return entities.map(entity -> {
            ProjectModel projectModel = modelMapper.map(entity, ProjectModel.class);
            if (entity.getUser() != null) {
                projectModel.setUserId(entity.getUser().getId());
            }
            return projectModel;
        });
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public boolean existsByCode(String code) {
        return jpa.existsByCode(code);
    }

}
