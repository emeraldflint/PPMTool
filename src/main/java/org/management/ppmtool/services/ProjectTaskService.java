package org.management.ppmtool.services;

import org.management.ppmtool.domain.ProjectTask;

public interface ProjectTaskService {
    ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask, String username);

    Iterable<ProjectTask> findBacklogById(String id, String username);

    ProjectTask findPTByProjectSequence(String backlog_id, String pt_id);

    ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlog_id, String pt_id);

    void deletePTByProjectSequence(String backlog_id, String pt_id);
}
