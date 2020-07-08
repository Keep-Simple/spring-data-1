package com.bsa.springdata.project.dto;

import com.bsa.springdata.project.Project;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class ProjectDto {
    private final UUID id;
    private final String name;
    private final String description;

    public static ProjectDto fromEntity(Project project) {
        return ProjectDto
                .builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .build();
    }
}
