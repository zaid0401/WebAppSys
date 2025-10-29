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
public class ApplicationService {

private static final org.slf4j.Logger log = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired private FirstServiceTT firstService;
    @Autowired private SecondServiceTT secondService;
    @Autowired private ThirdService thirdService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationService.class, args);
    }

    @Bean("applicationServiceInit")
    CommandLineRunner applicationServiceInit() {
        return args -> {
            log.info("--- ApplicationService: Starte Zählsequenz ---");

            // Führe die Zählung dreimal aus
            firstService.doCount();
            secondService.doCount();
            thirdService.doCount();

            log.info("--- ApplicationService: Zählsequenz beendet ---");
        };
    }
}
