package com.example.ottelukirjasto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ottelukirjasto.model.Bout;
import com.example.ottelukirjasto.model.BoutRepository;
import com.example.ottelukirjasto.model.Organization;
import com.example.ottelukirjasto.model.OrganizationRepository;
import com.example.ottelukirjasto.model.User;
import com.example.ottelukirjasto.model.UserRepository;

@SpringBootApplication
public class OttelukirjastoApplication {
	private static final Logger log = LoggerFactory.getLogger(OttelukirjastoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OttelukirjastoApplication.class, args);
	}

	@Bean
	public CommandLineRunner boutludemo(BoutRepository brepository, OrganizationRepository orepository,
			UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of bouts");

			orepository.save(new Organization("Ultimate Fighting Championship"));
			orepository.save(new Organization("Bellator MMA"));
			orepository.save(new Organization("ONE Championship"));
			orepository.save(new Organization("Cage Warriors"));
			orepository.save(new Organization("Cage (MMA Finland)"));

			Bout bout1 = new Bout("Darrion Caldwell", "Aj McKee",
					orepository.findByName("Ultimate Fighting Championship").get(0),
					"Mohegan Sun Arena, Uncasville, CT", "Featherweight", "19.11.2020",
					"Featherweight Grand Prix semi-final");

			Bout bout2 = new Bout("Esimerkkiottelija1", "Esimerkkiottelija2",
					orepository.findByName("ONE Championship").get(0), "Singapore", "Bantamweight", "13.02.2021",
					"Debut");

			Bout bout3 = new Bout("Israel Adesanya", "Jon Jones",
					orepository.findByName("Ultimate Fighting Championship").get(0), "Madison Square Garden",
					"Light Heavyweight", "19.04.2021", "Superfight");

			brepository.save(bout1);
			brepository.save(bout2);
			brepository.save(bout3);

			log.info("fetch all bouts");
			for (Bout bout : brepository.findAll()) {
				log.info(bout.toString());

			}

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
					"user@haaga-helia.fi", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"admin@haaga-helia.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};

	}
}
