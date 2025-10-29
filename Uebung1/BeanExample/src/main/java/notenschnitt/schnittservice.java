package notenschnitt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class schnittservice {

    private static final Logger log = LoggerFactory.getLogger(schnittservice.class);

    private List<Double> notenListe = new ArrayList<>();

    @PostConstruct
    public void notenHinzufuegen(){

        log.info("Service: Noteninitialisierung wird gestartet.");

        notenListe.add(1.0);
        notenListe.add(2.0);
        notenListe.add(3.0);
        notenListe.add(4.0);
        notenListe.add(5.0);

        log.info("Service: Noteninitialisierung abgeschlossen.");
    }

        public double berechneNotenschnitt() {
            if (notenListe.isEmpty()) 
                return 0.0;
            
            double summe = 0;
            for (double n : notenListe) {
                summe += n;}

                return summe / notenListe.size();
        
    }

    @PreDestroy
    public void notenLoeschen(){
        notenListe.clear();
        log.info("Service: Notenliste wurde geleert.");
    }

}
