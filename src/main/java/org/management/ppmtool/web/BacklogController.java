package org.management.ppmtool.web;

import org.management.ppmtool.domain.ProjectTask;
import org.management.ppmtool.services.MapValidationErrorService;
import org.management.ppmtool.services.ProjectTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {
    private ProjectTaskService projectTaskService;
    private MapValidationErrorService mapValidationErrorService;

    BacklogController(ProjectTaskService projectTaskService, MapValidationErrorService mapValidationErrorService) {
        this.projectTaskService = projectTaskService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/{backlog_id}")
    public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody ProjectTask projectTask, @PathVariable String backlog_id, BindingResult result) {

        ResponseEntity<?> erroMap = mapValidationErrorService.MapValidationService(result);
        if (erroMap != null) {
            return erroMap;
        }

        ProjectTask addedTask = projectTaskService.addProjectTask(backlog_id, projectTask);

        return new ResponseEntity<>(addedTask, HttpStatus.CREATED);
    }
}
