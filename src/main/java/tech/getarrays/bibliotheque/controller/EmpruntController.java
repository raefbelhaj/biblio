package tech.getarrays.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.Emprunt;
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

    @GetMapping
    public ResponseEntity<List<Emprunt>> getAllEmprunts() {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable Long id) {
        Optional<Emprunt> emprunt = empruntService.getEmpruntById(id);

        return emprunt.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Emprunt>> getEmpruntsByUserId(@PathVariable Long userId) {
        List<Emprunt> emprunts = empruntService.getEmpruntsByUserId(userId);
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }

    @PostMapping("/createEmprunt")
    public ResponseEntity<Emprunt> createEmprunt(@RequestBody EmpruntRequest empruntRequest) {
        Emprunt emprunt = empruntService.createEmprunt(
                empruntRequest.getUserId(),
                empruntRequest.getStartDate(),
                empruntRequest.getEndDate()
        );

        return new ResponseEntity<>(emprunt, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(
            @PathVariable Long id,
            @RequestBody EmpruntRequest empruntRequest
    ) {
        Emprunt emprunt = empruntService.updateEmprunt(
                id,
                empruntRequest.getStartDate(),
                empruntRequest.getEndDate()
        );

        return emprunt != null ?
                new ResponseEntity<>(emprunt, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
