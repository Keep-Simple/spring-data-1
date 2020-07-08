package com.bsa.springdata.team.dto;

import com.bsa.springdata.team.Technology;
import lombok.Builder;

import java.util.UUID;

@Builder
public class TechnologyDto {
    private final UUID id;
    private final String name;
    private final String description;
    private final String link;

    public static TechnologyDto fromEntity(Technology technology) {
        return TechnologyDto
                .builder()
                .id(technology.getId())
                .name(technology.getName())
                .description(technology.getDescription())
                .link(technology.getLink())
                .build();
    }
}
