package com.innerconsulting.scoreneo.controller;

import com.innerconsulting.scoreneo.model.Project;
import com.innerconsulting.scoreneo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    @PostMapping("/")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject=projectService.saveProject(project);

        return new ResponseEntity<>(createdProject,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project= projectService.findProjectById(id);
        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Project>> getAllProject() {
        Iterable<Project> project= projectService.findAllProjects();
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable Long id) {
        Project project= projectService.findProjectById(id);
        if (project!= null) {
            projectService.deleteProjectById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
