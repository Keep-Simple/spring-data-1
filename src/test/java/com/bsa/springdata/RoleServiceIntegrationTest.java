//package com.bsa.springdata;
//
//import com.bsa.springdata.office.Office;
//import com.bsa.springdata.role.Role;
//import com.bsa.springdata.role.RoleRepository;
//import com.bsa.springdata.role.RoleService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class RoleServiceIntegrationTest {
//	@Autowired
//	private RoleService roleService;
//	@Autowired
//	private RoleRepository roleRepository;
//
//	@Test
//	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	public void deleteRoleIfThereAreUsers() {
//		// arrange
//		var role = "dev";
//
//		// act
//		roleService.deleteRole(role);
//
//		// assert
//		var roles = roleRepository.findAll();
//
//		assertThat(roles.size()).isEqualTo(5);
//	}
//
//	@Test
//	@Sql(scripts = { "/clean.sql", "/data.sql" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	public void deleteRoleIfThereAreNoUsers() {
//		// arrange
//		var role = Role.builder()
//				.name("Designer")
//				.code("design")
//				.build();
//
//		roleRepository.save(role);
//
//		// act
//		roleService.deleteRole(role.getCode());
//
//		// assert
//		var roles = roleRepository.findAll();
//
//		assertThat(roles.size()).isEqualTo(5);
//	}
//}
