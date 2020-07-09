package com.bsa.springdata.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CreateProjectRequestDto {
    private final String projectName;
    private final String projectDescription;
    private final String tech;
    private final String techDescription;
    private final String techLink;
    private final String teamArea;
    private final String teamRoom;
    private final String teamName;
}
