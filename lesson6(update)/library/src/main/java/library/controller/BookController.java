package library.controller;

import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController

public class BookController {

    private BookService bookService;
    private final AtomicLong bookcounter = new AtomicLong();

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @RequestMapping("/registerbooks")
    public Book registerBook(@RequestParam(value = "title", defaultValue = " ") String title, @RequestParam(value = "isbn", defaultValue = " ") String isbn) {
        Book book = new Book(bookcounter.incrementAndGet(), title, isbn);
        return bookService.registerBook(book);
    }

    @GetMapping
    @RequestMapping("/books")
    public List<Book> listBooks() {
        return bookService.listBooks();
    }


}
