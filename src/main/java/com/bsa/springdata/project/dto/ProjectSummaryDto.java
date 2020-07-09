package com.bsa.springdata.project.dto;

import org.springframework.beans.factory.annotation.Value;

public interface ProjectSummaryDto {
    String getName();

    @Value("#{target.teamsnumber}")
    long getTeamsNumber();

    @Value("#{target.devsnumber}")
    long getDevelopersNumber();

    @Value("#{target.techs}")
    String getTechnologies();
}
