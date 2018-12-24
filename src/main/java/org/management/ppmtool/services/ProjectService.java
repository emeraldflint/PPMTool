package org.management.ppmtool.services;

import org.management.ppmtool.domain.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);

    Project findProjectByIdentifier(String projectId);

    Iterable<Project> findAllProjects();

    void deleteProjectByIdentifier(String projectId);

    Project updateProject(Project project);
}
