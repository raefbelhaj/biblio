package tech.getarrays.bibliotheque.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.bibliotheque.models.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
    // Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
}
