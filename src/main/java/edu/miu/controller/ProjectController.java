package edu.miu.controller;

import edu.miu.domain.Project;
import edu.miu.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Project> findAll() {
        List<Project> projects = projectService.findAll();
        return projects;
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectService.findOne(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processAddNewProject(@RequestBody Project project) {
        projectService.save(project);
    }
}