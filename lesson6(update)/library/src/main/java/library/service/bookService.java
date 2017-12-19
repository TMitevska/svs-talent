package library.service;

import library.model.Book;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public bookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book registerBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> listBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        return this.bookRepository.save(book);
    }
}
