package notenschnitt;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class schnittController {

    @Autowired
    private schnittservice service;

    // 1. Endpunkt zum ANZEIGEN der Notenliste und des Formulars (GET /noten)
    @GetMapping("/noten")
    public List<Double> showNotenUebersicht (Model model) {

        // Daten für die View vorbereiten: Notenliste und Durchschnitt
        List<Double> notenListe = service.getNotenListe();
        double notenschnitt = service.berechneNotenschnitt();

        // Füge Daten zum Model hinzu, damit das Template darauf zugreifen kann
        model.addAttribute("Notenliste", notenListe);
        model.addAttribute("Notenschnitt", notenschnitt);

        // Liefere das Template "notenListe.html" aus
        return notenListe;
    }

    // 2. Endpunkt zur VERARBEITUNG der Formulareingabe (POST /noten/add)
    @PostMapping("/noten/add")
    public String addNote(@RequestParam ("neueNote") double note) {

        // Die Note aus dem Formular entgegennehmen und zum Service hinzufügen
        service.addNote(note);

        // Nach dem Hinzufügen leiten wir den Nutzer zurück zur Übersichtsseite
        return "redirect:/noten";
    }
    

    //public double getNotenschnitt(double[] noten) {
     //   return service.berechneNotenschnitt();
    //}

    //public double getNotenschnitt() {
    //    return service.berechneNotenschnitt();
    //}

}
