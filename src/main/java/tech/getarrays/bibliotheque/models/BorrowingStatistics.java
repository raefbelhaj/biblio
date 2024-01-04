package tech.getarrays.bibliotheque.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BorrowingStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalBorrowings;

    private int totalBooks;

    private int totalMembers;

    private int totalReservation;

    public BorrowingStatistics() {
        // Default constructor required by JPA
    }

    public BorrowingStatistics(int totalBorrowings, int totalBooks, int totalMembers, int totalReservation) {
        this.totalBorrowings = totalBorrowings;
        this.totalBooks = totalBooks;
        this.totalMembers = totalMembers;
        this.totalReservation = totalReservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalBorrowings() {
        return totalBorrowings;
    }

    public void setTotalBorrowings(int totalBorrowings) {
        this.totalBorrowings = totalBorrowings;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public int getTotalReservation() {
        return totalReservation;
    }

    public void setTotalReservation(int totalReservation) {
        this.totalReservation = totalReservation;
    }

    // You can add more fields for specific statistics...

    // Getters and Setters
}
