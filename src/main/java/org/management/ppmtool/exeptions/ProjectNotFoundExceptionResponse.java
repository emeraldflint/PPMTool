package org.management.ppmtool.exeptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectNotFoundExceptionResponse {
    private String ProjectNotFound;

    public ProjectNotFoundExceptionResponse(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }
}
