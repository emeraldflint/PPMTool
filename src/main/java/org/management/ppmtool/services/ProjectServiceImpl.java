package org.management.ppmtool.services;

import org.management.ppmtool.domain.Backlog;
import org.management.ppmtool.domain.Project;
import org.management.ppmtool.exeptions.ProjectIdException;
import org.management.ppmtool.repositories.BacklogRepository;
import org.management.ppmtool.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private BacklogRepository backlogRepository;

    ProjectServiceImpl(ProjectRepository projectRepository, BacklogRepository backlogRepository) {
        this.projectRepository = projectRepository;
        this.backlogRepository = backlogRepository;
    }

    @Override
    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);

        if (project == null) {
            throw new ProjectIdException("Project ID '" + projectId + "' doesn't exist");
        }

        return project;
    }

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            if (project.getId() == null) {
                Backlog backlog = new Backlog();
                project.setBacklog(backlog);
                backlog.setProject(project);
                backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            }

            if (project.getId() != null) {
                project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
            }

            return projectRepository.save(project);

        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }
    }

    @Override
    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null) {
            throw new ProjectIdException("Can't delete project with ID '" + projectId + "'. This project doesn't exist");
        }

        projectRepository.delete(project);
    }

    @Override
    public Project updateProject(Project project) {
        Project existingProject = projectRepository.findById(project.getId()).orElseGet(null);

        if (existingProject == null) {
            throw new ProjectIdException("Can't update project with ID '" + project.getId() + "'. This project doesn't exist");
        }

        if ((existingProject.getId() != null && project.getId() != null) && existingProject.getId().equals(project.getId())) {
            project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
        }

        return projectRepository.save(project);
    }
}
