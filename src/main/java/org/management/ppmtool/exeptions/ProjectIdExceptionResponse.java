package org.management.ppmtool.exeptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class ProjectIdExceptionResponse {

    private String projectIdentifier;

    ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
