package edu.fra.uas;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fra.uas.service.FirstServiceTT;
import edu.fra.uas.service.SecondServiceTT;
import edu.fra.uas.service.ThirdService;

@SpringBootApplication
public class SpringDependencyInjectionApplication {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(SpringDependencyInjectionApplication.class);

	@Autowired private FirstServiceTT firstService;
	@Autowired private SecondServiceTT secondService;
	@Autowired private ThirdService thirdService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDependencyInjectionApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			log.info("--- Starte Zählsequenz ---");
			// Führe die Zählung dreimal aus
			firstService.doCount();
			secondService.doCount();
			thirdService.doCount();
			log.info("--- Zählsequenz beendet ---");
		};
	}
}
