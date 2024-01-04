package tech.getarrays.bibliotheque.models;

import jakarta.persistence.*;


import java.time.LocalDate;



@Entity
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private int NumberOfCopies;

    @OneToOne
    @JoinColumn(name = "category_id")

    private category category;
    public Book() {
    }

    public Book(Long id, String title, String author, String isbn, LocalDate publicationDate, int numberOfCopies, tech.getarrays.bibliotheque.models.category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        NumberOfCopies = numberOfCopies;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfCopies() {
        return NumberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        NumberOfCopies = numberOfCopies;
    }

    public tech.getarrays.bibliotheque.models.category getCategory() {
        return category;
    }

    public void setCategory(tech.getarrays.bibliotheque.models.category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", category=" + category +
                '}';
    }


    // Getters and setters
}
