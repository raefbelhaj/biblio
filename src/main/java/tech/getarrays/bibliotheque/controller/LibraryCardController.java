package tech.getarrays.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.LibraryCard;
import tech.getarrays.bibliotheque.service.LibraryCardService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library-cards")
public class LibraryCardController {

    private final LibraryCardService libraryCardService;

    @Autowired
    public LibraryCardController(LibraryCardService libraryCardService) {
        this.libraryCardService = libraryCardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LibraryCard>> getAllLibraryCards() {
        List<LibraryCard> libraryCards = libraryCardService.getAllLibraryCards();
        return new ResponseEntity<>(libraryCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryCard> getLibraryCardById(@PathVariable Long id) {
        Optional<LibraryCard> libraryCard = libraryCardService.getLibraryCardById(id);
        return libraryCard.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LibraryCard> addLibraryCard(@RequestBody LibraryCard libraryCard) {
        LibraryCard createdLibraryCard = libraryCardService.addLibraryCard(libraryCard);
        return new ResponseEntity<>(createdLibraryCard, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryCard(@PathVariable Long id) {
        libraryCardService.deleteLibraryCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Vous pouvez ajouter d'autres méthodes en fonction des besoins de votre application
}
