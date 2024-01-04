package tech.getarrays.bibliotheque.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.bibliotheque.models.BorrowingStatistics;

public interface BorrowingStatisticsRepository extends JpaRepository<BorrowingStatistics, Long> {
    // Ajoutez des requêtes personnalisées si nécessaire
}
