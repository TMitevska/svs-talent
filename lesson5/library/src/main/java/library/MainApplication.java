package library;

import library.Book.BookApplication;
import library.Book.BookRepository;
import library.Book.MemberApplication;
import library.Book.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;
@SpringBootApplication
@EnableJpaRepositories
public class MainApplication {
    public static void main(String[] argc)
    {
        Scanner s=new Scanner(System.in);
        ConfigurableApplicationContext context= SpringApplication.run(MainApplication.class,argc);
        MemberRepository memberrepo=context.getBean(MemberRepository.class);
        BookRepository bookrepo=context.getBean(BookRepository.class);
        while(true)
        {
            System.out.println("Register member or book. Enter 'book' or 'member'");

            String option=s.nextLine().toLowerCase();
            if(option.equals("book")) {

                System.out.println("Starting bookApplication");
            BookApplication bookapp= new BookApplication(bookrepo);
            bookapp.start();

            }
                else if(option.equals("member"))
            {
                System.out.println("Starting memberApplication");
                MemberApplication memberapp=new MemberApplication(memberrepo,bookrepo);
                memberapp.start();

            }
            else
            { System.out.println("exit");
                break;
            }
            }


    }
}
