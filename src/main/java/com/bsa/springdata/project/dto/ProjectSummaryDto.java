package com.bsa.springdata.project.dto;

import org.springframework.beans.factory.annotation.Value;

// TODO: Use this interface when you make a projection from native query.
//  If you don't use native query replace this interface with a simple POJO
public interface ProjectSummaryDto {
    String getName();

    @Value("#{target.teamsnumber}")
    long getTeamsNumber();

    @Value("#{target.devsnumber}")
    long getDevelopersNumber();

    @Value("#{target.techs}")
    String getTechnologies();
}
