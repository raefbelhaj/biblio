package tech.getarrays.bibliotheque.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarrays.bibliotheque.models.Book;

import java.util.Optional;
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    // Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
}
