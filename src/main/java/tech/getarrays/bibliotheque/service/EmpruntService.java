package tech.getarrays.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.models.Emprunt;
import tech.getarrays.bibliotheque.models.User;
import tech.getarrays.bibliotheque.Repo.EmpruntRepository;
import tech.getarrays.bibliotheque.Repo.UserRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final UserRepo userRepository;

    @Autowired
    public EmpruntService(EmpruntRepository empruntRepository, UserRepo userRepository) {
        this.empruntRepository = empruntRepository;
        this.userRepository = userRepository;
    }

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    public List<Emprunt> getEmpruntsByUserId(Long userId) {
        return empruntRepository.findByUserId(userId);
    }

    public Emprunt createEmprunt(Long userId, LocalDate startDate, LocalDate endDate) {



            Emprunt emprunt = new Emprunt(userId, startDate, endDate);
            return empruntRepository.save(emprunt);
        }

        // Handle user not found



    public Emprunt updateEmprunt(Long id, LocalDate startDate, LocalDate endDate) {
        Optional<Emprunt> optionalEmprunt = empruntRepository.findById(id);

        if (optionalEmprunt.isPresent()) {
            Emprunt emprunt = optionalEmprunt.get();
            emprunt.setStartDate(startDate);
            emprunt.setEndDate(endDate);
            return empruntRepository.save(emprunt);
        }

        // Handle emprunt not found
        return null;
    }

    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }

    public Optional<Emprunt> getEmpruntById(Long id) {
        return empruntRepository.findById(id);
    }
}
