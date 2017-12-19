package library.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class BookApplication {
    private BookRepository bookRepository;

    @Autowired
    public BookApplication(BookRepository bookRepository) {
        this.bookRepository =bookRepository;
    }
    public void start()
    {

        Scanner s=new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter option 'register', 'list' or 'go back'");
            String option=s.nextLine().toLowerCase();
            if(option.equals("register"))
            {    System.out.println("Enter title and isbn'");
                 String title=s.nextLine().toLowerCase();

                 Long isbn=Long.parseLong(s.nextLine().toLowerCase());
                 this.bookRepository.save(new Book(title,isbn));
            }
            else  if(option.equals("list"))
            {
                Iterable<Book> books=this.bookRepository.findAll();

                for(Book book:books){
                    book.displayMembers();
                }
            }

            else
            {
                break;
            }

        }
    }
}
