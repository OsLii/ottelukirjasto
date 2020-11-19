package com.example.ottelukirjasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.ottelukirjasto.model.Bout;
import com.example.ottelukirjasto.model.BoutRepository;
import com.example.ottelukirjasto.model.Organization;

@DataJpaTest
public class BoutRepositoryTest {

	@Autowired
	private BoutRepository brepository;

	//Luodaan testiottelija ja haetaan sitä samalla nimellä ja katsotaan matchaako
	@Test
	public void findByIdShouldReturnBout() {
		List<Bout> bouts = brepository.findByCompetitor1("Darrion Caldwell");
		assertThat(bouts).hasSize(1);
		assertThat(bouts.get(0).getCompetitor1()).isEqualTo("Darrion Caldwell");
	}
	
	//Luodaan uusi testiottelu, lsätään se listaan ja katsotaan että listassa on ottelu
	@Test
	public void createNewBout() {
		Bout bout = new Bout("Testcompetitor1", "Testcompetitor2", new Organization("Testorganization"), "Testplace",
				"Testdivision", "Testdate", "Testinfo");
		brepository.save(bout);
		assertThat(bout.getId()).isNotNull();
	}

	//Etsitään ottelija1 perusteella ottelijaa ja poistetaan se. Tarkistetaan että sitä ei enään ole
	@Test
	public void deleteBout() {
		List<Bout> bouts = brepository.findByCompetitor1("Darrion Caldwell");
		brepository.deleteById(bouts.get(0).getId());
		assertThat(brepository.findByCompetitor1("Darrion Caldwell")).hasSize(0);

	}

}
