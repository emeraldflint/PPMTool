package org.management.ppmtool.services;

import org.management.ppmtool.domain.Project;
import org.management.ppmtool.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository projectRepository;

    ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveOrUpdateProject(Project project) {
        return projectRepository.save(project);
    }
}
