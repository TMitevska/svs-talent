package library.Book;

import library.Book.Book;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name= "member")
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="name") private String name;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Column(name="book")
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "member_book", joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<Book> books=new LinkedList<Book>();
    @Column(name="embg") private String embg;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }
    public void lendBook(Book book){books.add(book);}
    public Member(){}
    public Member(String name,String embg){this.name=name;this.embg=embg;
        Hibernate.initialize(books);}

    public void displayBooks()
    {   System.out.println("____________________________________________________________________________");
        System.out.println(this.name +"   "+this.embg);

        if(books.isEmpty()==false){
            System.out.println("Name of books");
        for(Book book:books)
        {
            book.display();
        }}
        else
        {System.out.println("No records of books");}
        System.out.println("____________________________________________________________________________");
    }
    public void display()
    {
        System.out.println(this.name +"   "+this.embg);

    }
}
