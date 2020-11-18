package com.example.ottelukirjasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.ottelukirjasto.model.Bout;
import com.example.ottelukirjasto.model.BoutRepository;
import com.example.ottelukirjasto.model.Organization;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoutRepositoryTest {

	@Autowired
	private BoutRepository brepository;

	@Test
	public void findByIdShouldReturnBout() {
		List<Bout> books = brepository.findByCompetitor1("Darrion Caldwell");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getCompetitor1()).isEqualTo("Darrion Caldwell");
	}

	@Test
	public void createNewBout() {
		Bout bout = new Bout("Testcompetitor1", "Testcompetitor2", new Organization("Testorganization"), "Testplace",
				"Testdivision", "Testdate", "Testinfo");
		brepository.save(bout);
		assertThat(bout.getId()).isNotNull();
	}

	@Test
	public void deleteBout() {
		List<Bout> bouts = brepository.findByCompetitor1("Darrion Caldwell");
		brepository.deleteById(bouts.get(0).getId());
		assertThat(brepository.findByCompetitor1("Darrion Caldwell")).hasSize(0);

	}

}
