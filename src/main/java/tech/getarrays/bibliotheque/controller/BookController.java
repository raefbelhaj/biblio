package tech.getarrays.bibliotheque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.bibliotheque.models.Book;
import tech.getarrays.bibliotheque.service.BookService;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;


    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/all")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/all";
    }


    @GetMapping("/{bookId}")
    public String getBookById(@PathVariable Long bookId, Model model) {
        Optional<Book> book = bookService.getBookById(bookId);
        book.ifPresent(value -> model.addAttribute("book", value));
        return book.map(value -> "book/details").orElse("book/not-found");
    }


    @GetMapping("/add")
    public String getAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }


    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books/all";
    }


    @GetMapping("/update/{bookId}")
    public String getUpdateBookForm(@PathVariable Long bookId, Model model) {
        Optional<Book> book = bookService.getBookById(bookId);
        book.ifPresent(value -> model.addAttribute("book", value));
        return book.map(value -> "book/update").orElse("book/not-found");
    }


    @PostMapping("/update/{bookId}")
    public String updateBook(@PathVariable Long bookId, @ModelAttribute Book updatedBook) {
        bookService.updateBook(bookId, updatedBook);
        return "redirect:/books/all";
    }


    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books/all";
    }


    @PostMapping("/addCopies/{bookId}")
    public String addCopies(
            @PathVariable Long bookId,
            @RequestParam int numberOfCopies) {
        bookService.addCopies(bookId, numberOfCopies);
        return "redirect:/books/all";
    }
}





















