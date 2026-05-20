package com.thienhhu.backend.service;

import com.thienhhu.backend.entity.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProjectService {

    private final List<Project> projects = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public ProjectService() {
        projects.add(new Project(
                idGenerator.incrementAndGet(),
                "Portfolio Backend API",
                "Spring Boot REST API for portfolio data.",
                "Java, Spring Boot, PostgreSQL",
                "https://github.com/thienhhu/portfolio-backend",
                true
        ));
        projects.add(new Project(
                idGenerator.incrementAndGet(),
                "Portfolio Frontend",
                "Responsive frontend consuming backend APIs.",
                "React, TypeScript, Tailwind CSS",
                "https://github.com/thienhhu/portfolio-frontend",
                false
        ));
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }

    public Optional<Project> getProjectById(Long id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst();
    }

    public Project createProject(Project project) {
        Project newProject = new Project(
                idGenerator.incrementAndGet(),
                project.getTitle(),
                project.getDescription(),
                project.getTechnologies(),
                project.getGithubUrl(),
                project.isFeatured()
        );
        projects.add(newProject);
        return newProject;
    }

    public Optional<Project> updateProject(Long id, Project projectRequest) {
        return getProjectById(id).map(existingProject -> {
            existingProject.setTitle(projectRequest.getTitle());
            existingProject.setDescription(projectRequest.getDescription());
            existingProject.setTechnologies(projectRequest.getTechnologies());
            existingProject.setGithubUrl(projectRequest.getGithubUrl());
            existingProject.setFeatured(projectRequest.isFeatured());
            return existingProject;
        });
    }

    public boolean deleteProject(Long id) {
        return projects.removeIf(project -> project.getId().equals(id));
    }
}
