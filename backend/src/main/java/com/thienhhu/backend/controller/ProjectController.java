package com.thienhhu.backend.controller;

import com.thienhhu.backend.dto.response.ProjectResponseDto;
import com.thienhhu.backend.entity.Project;
import com.thienhhu.backend.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects().stream()
                .map(ProjectResponseDto::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(ProjectResponseDto::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProjectResponseDto.from(createdProject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project)
                .map(ProjectResponseDto::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        boolean deleted = projectService.deleteProject(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
