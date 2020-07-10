package com.bsa.springdata.project;

import com.bsa.springdata.project.dto.ProjectSummaryDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

    @Query(value = "select p from Project p" +
            "    inner join p.teams t" +
            "    inner join t.technology tech" +
            "    where tech.name = :tech" +
            "    order by t.users.size desc")
    List<Project> findTop5ByTechnology(String tech, Pageable pg);


    @Query("select p from Project p " +
            "inner join p.teams t " +
            "order by p.teams.size desc, " +
            "t.users.size desc, " +
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
