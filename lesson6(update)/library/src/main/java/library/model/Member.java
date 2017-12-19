package library.model;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @ManyToMany(targetEntity = Book.class, fetch = FetchType.EAGER)
    private List<Book> books = new LinkedList<Book>();
    private String embg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", embg='" + this.embg + '\'' +
                '}';
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public void lendBook(Book book) {
        books.add(book);
    }

    public Member() {
    }

    public Member(String name, String embg) {
        this.name = name;
        this.embg = embg;
    }

    public Member(Long id, String name, String embg) {
        this.name = name;
        this.embg = embg;
        this.id = id;
    }

    public void displayBooks() {
        System.out.println("____________________________________________________________________________");
        System.out.println(this.name + "   " + this.embg);

        if (books.isEmpty() == false) {
            System.out.println("Name of books");
            for (Book book : books) {
                book.display();
            }
        } else {
            System.out.println("No records of books");
        }
        System.out.println("____________________________________________________________________________");
    }

    public void display() {
        System.out.println(this.name + "   " + this.embg);

    }
}
