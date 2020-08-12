package edu.miu.controller;

import edu.miu.domain.Project;
import edu.miu.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return projectService.findOne(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processAddNewProject(@Valid @RequestBody Project project) {
        projectService.save(project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjectById(@PathVariable("id") Long id) {
        projectService.deleteById(id);
    }

}
