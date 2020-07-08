package com.bsa.springdata.team.dto;

import com.bsa.springdata.project.dto.ProjectDto;
import com.bsa.springdata.team.Team;
import lombok.Builder;

import java.util.UUID;

@Builder
public class TeamDto {
    private final UUID id;
    private final String name;
    private final String room;
    private final String area;
    private final ProjectDto project;
    private final TechnologyDto technology;

    public static TeamDto fromEntity(Team team) {
        return TeamDto
                .builder()
                .id(team.getId())
                .name(team.getName())
                .area(team.getArea())
                .room(team.getRoom())
                .project(ProjectDto.fromEntity(team.getProject()))
                .technology(TechnologyDto.fromEntity(team.getTechnology()))
                .build();
    }
}
