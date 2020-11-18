package com.example.ottelukirjasto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.ottelukirjasto.model.User;
import com.example.ottelukirjasto.model.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	public void createNewUser() {
		User user = new User("TestUser", "TestUserPassword", "TestUserEmail", "User");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
}
