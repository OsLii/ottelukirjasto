package com.example.ottelukirjasto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.ottelukirjasto.web.OtteluController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OttelukirjastoApplicationTests {

	@Autowired
	private OtteluController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
