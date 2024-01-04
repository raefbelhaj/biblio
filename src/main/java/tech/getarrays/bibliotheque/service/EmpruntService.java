package tech.getarrays.bibliotheque.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.models.Book;
import tech.getarrays.bibliotheque.models.Emprunt;

import tech.getarrays.bibliotheque.Repo.EmpruntRepository;
import tech.getarrays.bibliotheque.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmpruntService {

    private final EmpruntRepository empruntRepository;



    public void createEmprunt(User user, LocalDate startDate, LocalDate endDate, Book book) {
        Emprunt emprunt = new Emprunt(user, startDate, endDate, book);
        empruntRepository.save(emprunt);
    }

    public Optional<Emprunt> getEmpruntById(Long empruntId) {
        return empruntRepository.findById(empruntId);
    }

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    // Ajoutez d'autres méthodes de service au besoin

}
