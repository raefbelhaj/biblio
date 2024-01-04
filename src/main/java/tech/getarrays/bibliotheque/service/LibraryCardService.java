package tech.getarrays.bibliotheque.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.Repo.LibraryCardRepository;
import tech.getarrays.bibliotheque.models.LibraryCard;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LibraryCardService {

    private final LibraryCardRepository libraryCardRepository;



    public List<LibraryCard> getAllLibraryCards() {
        return libraryCardRepository.findAll();
    }

    public Optional<LibraryCard> getLibraryCardById(Long id) {
        return libraryCardRepository.findById(id);
    }

    public LibraryCard addLibraryCard(LibraryCard libraryCard) {
        return libraryCardRepository.save(libraryCard);
    }

    public void deleteLibraryCard(Long id) {
        libraryCardRepository.deleteById(id);
    }

    // Vous pouvez ajouter d'autres méthodes en fonction des besoins de votre application

}
