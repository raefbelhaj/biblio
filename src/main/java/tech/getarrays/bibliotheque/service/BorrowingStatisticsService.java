package tech.getarrays.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.Repo.*;
import tech.getarrays.bibliotheque.models.BorrowingStatistics;

@Service
public class BorrowingStatisticsService {

    @Autowired
    private BorrowingStatisticsRepository borrowingStatisticsRepository;

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReservationRepository reservationRepository;

    public BorrowingStatistics generateBorrowingStatistics() {
        int totalBorrowings = (int) empruntRepository.count();
        int totalBooks = (int) bookRepo.count();
        int totalMembers = (int) userRepo.count();
        int totalReservation = (int) reservationRepository.count();

        // Create an instance of borrowing statistics
        BorrowingStatistics borrowingStatistics = new BorrowingStatistics();
        borrowingStatistics.setTotalBorrowings(totalBorrowings);
        borrowingStatistics.setTotalBooks(totalBooks);  // New line
        borrowingStatistics.setTotalMembers(totalMembers);
        borrowingStatistics.setTotalReservation(totalReservation);

        // New line

        // Save to the database
        return borrowingStatisticsRepository.save(borrowingStatistics);
    }

    // Other methods for generating reports...
}
