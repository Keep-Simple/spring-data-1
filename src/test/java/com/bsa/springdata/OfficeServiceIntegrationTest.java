package com.bsa.springdata;

import com.bsa.springdata.office.Office;
import com.bsa.springdata.office.OfficeRepository;
import com.bsa.springdata.office.OfficeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OfficeServiceIntegrationTest {
	@Autowired
	private OfficeService officeService;
	@Autowired
	private OfficeRepository officeRepository;

	@Test
	public void getOfficesByTechnology() {
		// arrange
		var technology = "Java";

		// act
		var offices = officeService.getByTechnology(technology);

		// assert
		assertThat(offices.size()).isEqualTo(1);
	}

	@Test
    @Transactional
	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void updateOfficeIfThereIsAProject() {
		// arrange
		var oldAddress = "Chornovola 59";
		var newAddress = "Chornovola 31";

		// act
		var updatedOffice = officeService.updateAddress(oldAddress, newAddress);

		// assert
		assertThat(updatedOffice.isPresent()).isTrue();
		assertThat(updatedOffice.get().getAddress()).isEqualTo(newAddress);
	}

	@Test
    @Transactional
	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void updateOfficeIfThereIsNoProject() {
		// arrange
		var oldAddress = "Fake address";
		var newAddress = "Chornovola 31";

		var fakeOffice = Office.builder()
				.address(oldAddress)
				.city("Lviv")
				.build();

		officeRepository.save(fakeOffice);

		// act
		var updatedOffice = officeService.updateAddress(oldAddress, newAddress);

		// assert
		assertThat(updatedOffice.isEmpty()).isTrue();
	}
}
