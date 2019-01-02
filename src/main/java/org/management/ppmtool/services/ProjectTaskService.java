package org.management.ppmtool.services;

import org.management.ppmtool.domain.ProjectTask;

public interface ProjectTaskService {
    ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask);

    Iterable<ProjectTask>findBacklogById(String id);

    ProjectTask findPTByProjectSequence(String backlog_id, String pt_id);
}
