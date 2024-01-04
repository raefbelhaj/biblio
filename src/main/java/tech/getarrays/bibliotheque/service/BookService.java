package tech.getarrays.bibliotheque.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.exception.BookNotFoundException;
import tech.getarrays.bibliotheque.models.Book;
import tech.getarrays.bibliotheque.Repo.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long bookId) {
        return bookRepo.findById(bookId);
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public void updateBook(Long bookId, Book updatedBook) {

        Optional<Book> existingBookOptional = bookRepo.findById(bookId);
        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setPublicationDate(updatedBook.getPublicationDate());
            existingBook.setCategory(updatedBook.getCategory());
            bookRepo.save(existingBook);
        }
    }

    public void deleteBook(Long bookId) {
        bookRepo.deleteById(bookId);
    }



    public void addCopies(Long bookId, int numberOfCopies) {
        Optional<Book> optionalBook = bookRepo.findById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            int currentCopies = book.getNumberOfCopies();
            book.setNumberOfCopies(currentCopies + numberOfCopies);
            bookRepo.save(book);
        } else {
            // Gérer le cas où le livre avec l'ID spécifié n'est pas trouvé
            throw new BookNotFoundException("Livre introuvable avec l'ID : " + bookId);
        }
    }
}
