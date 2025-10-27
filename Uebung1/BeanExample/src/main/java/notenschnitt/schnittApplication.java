package notenschnitt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class schnittApplication {

    private static final Logger log = LoggerFactory.getLogger(schnittApplication.class);

    @Autowired
    private schnittController controller;

    public static void main(String[] args) {
        SpringApplication.run(schnittApplication.class, args);
    }

    @Bean
    CommandLineRunner init () {
    return args -> {
    double schnitt = controller.getNotenschnitt(new double[]{1.3, 2.0, 1.7});
            log.info("Notenschnitt: " + schnitt);
    };
    }

}
