package tech.getarrays.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.models.Reservation;
import tech.getarrays.bibliotheque.Repo.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> existingReservationOptional = reservationRepository.findById(id);

        if (existingReservationOptional.isPresent()) {
            Reservation existingReservation = existingReservationOptional.get();

            // Update the fields of the existing reservation with the values from updatedReservation
            existingReservation.setUser(updatedReservation.getUser());
            existingReservation.setBook(updatedReservation.getBook());
            existingReservation.setFulfilled(updatedReservation.isFulfilled());

            // Save the updated reservation to the repository
            return reservationRepository.save(existingReservation);
        } else {
            // Handle the case where the reservation with the given id is not found
            // You may choose to throw an exception or handle it as needed
            return null; // or throw an exception
        }
    }
}

    // You can add more methods as needed, such as updating reservations or finding reservations by user or book.

