package org.management.ppmtool.services;

import org.management.ppmtool.domain.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project, String username);

    Project findProjectByIdentifier(String projectId, String username);

    Iterable<Project> findAllProjects(String username);

    void deleteProjectByIdentifier(String projectId, String username);

    Project updateProject(Project project);
}
