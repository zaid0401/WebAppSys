package notenschnitt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController //Sagt Spring, dieser Controller liefert JSON, kein HTML
@RequestMapping("/api/noten")//Basis-URL für alle Endpunkte

public class NotenRestController {

@Autowired
private SchnittServiceNoten service;    //Zugriff auf Notenliste und Berechnung

//1. Endpunkt: Notenliste als JSON abrufen (GET /api/noten)

@GetMapping("")
public ResponseEntity<List<Double>> getNotenListe() {

    List<Double> notenListe = service.getNotenListe();

    if (notenListe.isEmpty()){
        //Keine Noten vorhanden, 204 No Content zurückgeben
        return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(notenListe); //200 OK mit Notenliste im Body
}

//2. Endpunkt: Liefert eine einzelne Note anhand ihres Index (GET /api/noten/{index})
@GetMapping("/{id}")
public ResponseEntity<Double> getNoteByIndex(@PathVariable int id) {

    List<Double> notenListe = service.getNotenListe();

    //Schutz: Index außerhalb der Liste?
    if (id < 0 || id >= notenListe.size()) {
        return ResponseEntity.status (HttpStatus.NOT_FOUND).build(); //404 Not Found
    }

    Double note = notenListe.get(id);

    //Note gefunden, 200 OK mit Einzelnote im Body zurückgeben
    return ResponseEntity.ok(note);
}

//3. Endpunkt: Neue Note hinzufügen (POST /api/noten)
@PostMapping("/add")
public ResponseEntity<String> addNote(@RequestBody Double note) {

    //Eingabe validieren: Note muss zwischen 1.0 und 6.0 liegen
    if (note < 1.0 || note > 6.0) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Ungültige Note. Bitte eine Note zwischen 1.0 und 6.0 eingeben.");
    }

    service.addNote(note);

    //Note erfolgreich hinzugefügt, 201 Created zurückgeben
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Note erfolgreich hinzugefügt.");
}

//4. Endpunkt: Aktualisiert eine existierende Note (PUT /api/noten/{index})
@PutMapping("/{id}")
public ResponseEntity<String> updateNote(@PathVariable int id, @RequestBody Double neueNote) {

    List<Double> notenListe = service.getNotenListe();

    //Exisistiert die Note an diesem Index?
    if (id < 0 || id >= notenListe.size()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note nicht gefunden.");
    }
    
    //Eingabe validieren
    if (neueNote < 1.0 || neueNote > 6.0) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Ungültige Note. Bitte eine Note zwischen 1.0 und 6.0 eingeben.");
    }

    //Note aktualisieren
    notenListe.set(id, neueNote);

    //Note erfolgreich aktualisiert, 200 OK zurückgeben
    return ResponseEntity.ok("Note erfolgreich aktualisiert.");
}

//5. Endpunkt: Löscht eine einzelne Note (DELETE /api/noten/{index})
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteNote(@PathVariable int id) {

    List<Double> notenListe = service.getNotenListe();

    //Existiert die Note an diesem Index?
    if (id < 0 || id >= notenListe.size()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note nicht gefunden.");
    }

    //Note löschen
    notenListe.remove(id);

    //Note erfolgreich gelöscht, 200 OK zurückgeben
    return ResponseEntity.ok("Note erfolgreich gelöscht.");
}

//6. Endpunkt: Liefert den berechneten Notenschnitt (GET /api/noten/schnitt)
@GetMapping("/schnitt")
public ResponseEntity<Double> getNotenschnitt() {

    double notenschnitt = service.berechneNotenschnitt();

    //Notenschnitt zurückgeben
    return ResponseEntity.ok(notenschnitt);
}

}