package com.example.ottelukirjasto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.ottelukirjasto.model.User;
import com.example.ottelukirjasto.model.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	// Luodaan uusi testiuser, lsätään se listaan ja katsotaan että listassa on user
	@Test
	public void createNewUser() {
		User user = new User("TestUser", "TestUserPassword", "TestUserEmail", "User");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
}
