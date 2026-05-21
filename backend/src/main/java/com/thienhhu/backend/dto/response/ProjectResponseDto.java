package com.thienhhu.backend.dto.response;

import com.thienhhu.backend.entity.Project;

public record ProjectResponseDto(
        Long id,
        String title,
        String description,
        String technologies,
        String githubUrl,
        boolean featured
) {
    public static ProjectResponseDto from(Project project) {
        return new ProjectResponseDto(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getTechnologies(),
                project.getGithubUrl(),
                project.isFeatured()
        );
    }
}
