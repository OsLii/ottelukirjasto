package com.example.ottelukirjasto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ottelukirjasto.model.Bout;
import com.example.ottelukirjasto.model.BoutRepository;

@SpringBootApplication
public class OttelukirjastoApplication {
	private static final Logger log = LoggerFactory.getLogger(OttelukirjastoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OttelukirjastoApplication.class, args);
	}

	@Bean
	public CommandLineRunner boutludemo(BoutRepository brepository) {
		return (args) -> {
			log.info("save a couple of bouts");

			Bout bout1 = new Bout("Darrion Caldwell", "Aj McKee", "Bellator MMA", "Mohegan Sun Arena, Uncasville, CT",
					"Featherweight", "19.11.2020", "Featherweight Grand Prix semi-final");
			Bout bout2 = new Bout("Darrion Caldwell", "Aj McKee", "Bellator MMA", "Mohegan Sun Arena, Uncasville, CT",
					"Featherweight", "19.11.2020", "Featherweight Grand Prix semi-final");
			Bout bout3 = new Bout("Darrion Caldwell", "Aj McKee", "Bellator MMA", "Mohegan Sun Arena, Uncasville, CT",
					"Featherweight", "19.11.2020", "Featherweight Grand Prix semi-final");

			brepository.save(bout1);
			brepository.save(bout2);
			brepository.save(bout3);

			log.info("fetch all bouts");
			for (Bout bout : brepository.findAll()) {
				log.info(bout.toString());

			}

		};

	}
}
