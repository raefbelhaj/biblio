package tech.getarrays.bibliotheque.Repo;

import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.bibliotheque.models.category;

public interface CategoryRepo extends JpaRepository<category, Long> {

}
