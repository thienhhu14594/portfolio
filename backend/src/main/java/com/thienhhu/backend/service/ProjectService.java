package com.thienhhu.backend.service;

import com.thienhhu.backend.entity.Project;
import com.thienhhu.backend.repository.ProjectRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        project.setId(null);
        return projectRepository.save(project);
    }

    public Optional<Project> updateProject(Long id, Project projectRequest) {
        return projectRepository.findById(id).map(existingProject -> {
            existingProject.setTitle(projectRequest.getTitle());
            existingProject.setDescription(projectRequest.getDescription());
            existingProject.setTechnologies(projectRequest.getTechnologies());
            existingProject.setGithubUrl(projectRequest.getGithubUrl());
            existingProject.setFeatured(projectRequest.isFeatured());
            return projectRepository.save(existingProject);
        });
    }

    public boolean deleteProject(Long id) {
        try {
            projectRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
    }
}
