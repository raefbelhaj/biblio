package tech.getarrays.bibliotheque.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.models.Book;
import tech.getarrays.bibliotheque.Repo.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
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
}
