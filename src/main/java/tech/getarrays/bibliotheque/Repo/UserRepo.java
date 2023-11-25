package tech.getarrays.bibliotheque.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.bibliotheque.models.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

}
