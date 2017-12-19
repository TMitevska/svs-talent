package library.service;

import library.model.Book;

import java.util.List;

public interface BookService {


    Book registerBook(Book book);

    List<Book> listBooks();

    Book updateBook(Book book);


}