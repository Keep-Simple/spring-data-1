package com.bsa.springdata;

import com.bsa.springdata.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {
	@Autowired
	private UserService userService;

	@Test
	public void getUsersByLastName() {
		// arrange
		var lastName = "b";
		var page = 0;
		var size = 10;

		// act
		var users = userService.findByLastName(lastName, page, size);

		// assert
		assertThat(users.size()).isEqualTo(3);
		assertThat(users.get(0).getLastName()).isEqualTo("Bain");
		assertThat(users.get(2).getExperience()).isEqualTo(5);
	}

	@Test
	public void getUsersByCity() {
		// arrange
		var city = "Lviv";

		// act
		var users = userService.findByCity(city);

		// assert
		assertThat(users.size()).isEqualTo(10);
		assertThat(users.get(9).getLastName()).isEqualTo("Yu");
	}

	@Test
	public void getUsersByExperience() {
		// arrange
		var experience = 5;

		// act
		var users = userService.findByExperience(experience);

		// assert
		assertThat(users.size()).isEqualTo(6);
		assertThat(users.get(5).getLastName()).isEqualTo("King");
	}

	@Test
	public void getUsersByRoomAndCity() {
		// arrange
		var city = "Lviv";
		var room = "red";

		// act
		var users = userService.findByRoomAndCity(city, room);

		// assert
		assertThat(users.size()).isEqualTo(4);
		assertThat(users.stream().anyMatch(x -> x.getLastName().equals("Peterson"))).isTrue();
	}

	@Test
	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void deleteUsersByExperience() {
		// arrange
		var experience = 5;

		// act
		var numberOfRemoved = userService.deleteByExperience(experience);

		// assert
		assertThat(numberOfRemoved).isEqualTo(14);
		var usersLeft = userService.getUsers();
		assertThat(usersLeft.size()).isEqualTo(6);
	}
}
