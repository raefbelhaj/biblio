package tech.getarrays.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.models.Emprunt;

import tech.getarrays.bibliotheque.Repo.EmpruntRepository;
import tech.getarrays.bibliotheque.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {

    private final EmpruntRepository empruntRepository;

    @Autowired
    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public void createEmprunt(User user, LocalDate startDate, LocalDate endDate) {
        Emprunt emprunt = new Emprunt(user, startDate, endDate);
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
