package com.bsa.springdata;

import com.bsa.springdata.team.TeamRepository;
import com.bsa.springdata.team.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TeamServiceIntegrationTest {
	@Autowired
	private TeamService teamService;
	@Autowired
	private TeamRepository teamRepository;

	@Test
	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void updateTeamWithSmallNumberOfDeveloper() {
		// arrange
		var devsNumber = 5;
		var oldTechnology = "JavaScript";
		var newTechnology = "Java";

		// act
		teamService.updateTechnology(devsNumber, oldTechnology, newTechnology);

		// assert
		var javaTeams = teamRepository.countByTechnologyName(newTechnology);

		assertThat(javaTeams).isEqualTo(4);
	}

	@Test
	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void extendTeamNameWithProjectAndTechnology() {
		// arrange
		var team = "Hipsters";

		// act
		teamService.normalizeName(team);

		// assert
		var updatedTeam = teamRepository.findByName("Hipsters_Facebook_JavaScript");

		assertThat(updatedTeam.isPresent()).isTrue();
	}
}
