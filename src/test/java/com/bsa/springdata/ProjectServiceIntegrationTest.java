package com.bsa.springdata;

import com.bsa.springdata.project.dto.CreateProjectRequestDto;
import com.bsa.springdata.project.ProjectService;
import com.bsa.springdata.team.TeamRepository;
import com.bsa.springdata.team.TechnologyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ProjectServiceIntegrationTest {
	@Autowired
	private ProjectService projectService;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TechnologyRepository technologyRepository;

	@Test
	public void getTop5ProjectsByTechnology() {
		// arrange
		var technology = "Java";

		// act
		var projects = projectService.findTop5ByTechnology(technology);

		// assert
		assertThat(projects.size()).isEqualTo(2);
		assertThat(projects.get(0).getName()).isEqualTo("Facebook");
	}

	@Test
	public void getTheBiggest() {
		// act
		var project = projectService.findTheBiggest();

		// assert
		assertThat(project.isPresent()).isTrue();
		assertThat(project.get().getName()).isEqualTo("Uber");
	}

	@Test
	public void getProjectsSummary() {
		// act
		var projects = projectService.getSummary();

		// assert
		assertThat(projects.size()).isEqualTo(3);
		var facebook = projects.get(0);
		assertThat(facebook.getName()).isEqualTo("Facebook");
		assertThat(facebook.getDevelopersNumber()).isEqualTo(8);
		assertThat(facebook.getTeamsNumber()).isEqualTo(2);
		assertThat(facebook.getTechnologies()).isEqualTo("JavaScript,Java");
	}

	@Test
	public void getProjectsWithRole() {
		// arrange
		var role = "Developer";

		// act
		var projectsNumber = projectService.getCountWithRole(role);

		// assert
		assertThat(projectsNumber).isEqualTo(3);
	}

	@Test
	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void createProjectWithTeamWithTechnology() {
		// arrange
		var createProjectRequest = new CreateProjectRequestDto(
			"Instagram",
			"Application to share pictures",
			"Python",
			"A powerful strongly typed language",
			"https://www.python.org/",
			"fullstack",
			"magenta",
			"Heroes"
		);

		// act
//		var projectId = projectService.createWithTeamAndTechnology(createProjectRequest);
//
//		// assert
//		var newTeam = teamRepository.findByName(createProjectRequest.getTeamName());
//		var newTechnology = technologyRepository.findByName(createProjectRequest.getTech());
//
//		assertThat(projectId).isNotNull();
//		assertThat(newTeam.isPresent()).isTrue();
//		assertThat(newTechnology.isPresent()).isTrue();
	}
}
