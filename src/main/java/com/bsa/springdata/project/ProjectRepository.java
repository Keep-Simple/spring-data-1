package com.bsa.springdata.project;

import com.bsa.springdata.project.dto.ProjectDto;
import com.bsa.springdata.project.dto.ProjectSummaryDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

     @Query(value = "select projects.id, projects.name, projects.description from Projects" +
             "    inner join teams t on projects.id = t.project_id" +
             "    inner join technologies tech on t.technology_id = tech.id" +
             "    inner join users u on t.id = u.team_id" +
             "    where tech.name = :tech" +
             "    group by projects.id" +
             "    order by count(projects.id) desc", nativeQuery = true)
    List<Project> findTop5ByTechnology(String tech, Pageable pg);


    @Query("select p from Project p " +
            "inner join p.teams t " +
            "order by size(p.teams) desc, " +
            "size(t.users) desc, " +
            "p.name desc")
    Optional<Project> findBiggestProject(PageRequest of);

    @Query("select count(distinct p) from Project p " +
            "inner join p.teams t " +
            "inner join t.users u " +
            "inner join u.roles r " +
            "where r.name = :role")
    int countProjectIfSomeOneHasRole(String role);


    @Query(value = "select projects.name," +
            "       count(distinct t) as teamsnumber," +
            "       count(distinct u) as devsnumber," +
            "       array_to_string(array_agg(distinct t2.name order by t2.name desc), ',') techs" +
            "            from Projects" +
            "            inner join teams t on projects.id = t.project_id" +
            "            inner join users u on t.id = u.team_id" +
            "            inner join technologies t2 on t.technology_id = t2.id" +
            "                group by projects.name " +
            "                order by projects.name", nativeQuery = true)
    List<ProjectSummaryDto> getSummary();
}
