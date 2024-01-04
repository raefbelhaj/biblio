package tech.getarrays.bibliotheque.models;

import jakarta.persistence.*;





import java.time.LocalDate;


@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")  // Adjust the column name based on your actual entity
    private Book book;

    public Emprunt(User user, LocalDate startDate, LocalDate endDate, Book book) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.book = book;
    }

    public Emprunt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Emprunt(User user, LocalDate startDate, LocalDate endDate) {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
