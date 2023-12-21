package tech.getarrays.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.Emprunt;
import tech.getarrays.bibliotheque.models.User;
import tech.getarrays.bibliotheque.request.EmpruntRequest;
import tech.getarrays.bibliotheque.service.EmpruntService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    private final EmpruntService empruntService;

    @Autowired
    public EmpruntController(EmpruntService empruntService) {

        this.empruntService = empruntService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmprunt(@RequestBody EmpruntRequest empruntRequest) {
        User user = empruntRequest.getUser();
        LocalDate startDate = empruntRequest.getStartDate();
        LocalDate endDate = empruntRequest.getEndDate();

        empruntService.createEmprunt(user, startDate, endDate);

        return new ResponseEntity<>("Emprunt créé avec succès", HttpStatus.CREATED);
    }

    @GetMapping("/{empruntId}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable Long empruntId) {
        Optional<Emprunt> emprunt = empruntService.getEmpruntById(empruntId);

        return emprunt.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Emprunt>> getAllEmprunts() {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }

    // Ajoutez d'autres méthodes du contrôleur au besoin

}
