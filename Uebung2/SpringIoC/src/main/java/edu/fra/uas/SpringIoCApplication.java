package edu.fra.uas;

import edu.fra.uas.v3autowired.Journeyman2;

// v1instantiating
// import edu.fra.uas.v1instantiating.MasterV1;

// v2setter
//import edu.fra.uas.v2setter.Drilling;
//import edu.fra.uas.v2setter.Journeyman;
//import edu.fra.uas.v2setter.MasterV2;

// v3autowired
import edu.fra.uas.v3autowired.MasterV3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringIoCApplication {

    // v1instantiating
    //@Autowired
    //private MasterV1 masterV1;
    //private MasterV2 masterV2;

    // v3autowired
    @Autowired
    private MasterV3 masterV3;

    @Autowired
    private Journeyman2 journeyman2;

    public static void main(String[] args) {
        SpringApplication.run(SpringIoCApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // v1instantiating
                //masterV1.delegateWork();

                //v2setter
                //MasterV2 masterV2 = new MasterV2();
                //masterV2.setJourneymanAndWork(new Journeyman(), new Drilling());
                //masterV2.delegateWork();

                // v3autowired
                masterV3.delegateWork();

                journeyman2.performWork();
            }
        };
        return action;
    }

}
