package tech.getarrays.bibliotheque.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super (message);
    }
}
