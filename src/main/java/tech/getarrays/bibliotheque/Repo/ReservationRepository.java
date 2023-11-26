package tech.getarrays.bibliotheque.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.bibliotheque.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteUnfulfilledReservationById(Long id);

}
