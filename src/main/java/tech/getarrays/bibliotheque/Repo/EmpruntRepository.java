package tech.getarrays.bibliotheque.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.bibliotheque.models.Emprunt;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

        List<Emprunt> findByUserId(Long userId);



    // Other custom query methods if needed


}
