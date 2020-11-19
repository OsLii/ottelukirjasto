package com.example.ottelukirjasto;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.ottelukirjasto.model.Organization;
import com.example.ottelukirjasto.model.OrganizationRepository;

@DataJpaTest
public class OrganizationRepositoryTest {
	@Autowired
	private OrganizationRepository orepository;

	// Luodaan testiorganisaatio ja haetaan sitä samalla nimellä ja katsotaan
	// matchaako
	@Test
	public void findByIdShouldReturnOrganization() {
		List<Organization> organizations = orepository.findByName("Bellator MMA");
		assertThat(organizations).hasSize(1);
		assertThat(organizations.get(0).getName()).isEqualTo("Bellator MMA");
	}

	// Luodaan uusi testiorganisaatio, lsätään se listaan ja katsotaan että listassa
	// on organisaatio
	@Test
	public void createNewOrganization() {
		Organization organization = new Organization("TestOrganization");
		orepository.save(organization);
		assertThat(organization.getName()).isNotNull();
	}

}