package org.management.ppmtool.services;

import org.management.ppmtool.domain.Project;

public interface ProjectService {

    Project saveOrUpdateProject(Project project);

    Project findProjectByIdentifier(String projectId);
}
