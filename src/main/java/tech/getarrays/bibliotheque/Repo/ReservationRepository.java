package tech.getarrays.bibliotheque.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.bibliotheque.models.Reservation;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteUnfulfilledReservationById(Long id);
    Optional<Reservation> findById(Long id);
}
