package library.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import library.model.Member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Book {
    @Id

    private Long id;
    private String title;
    private String isbn;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @JsonIgnore
    @ManyToMany(targetEntity = Member.class, mappedBy = "books")
    private List<Member> members = new LinkedList<Member>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void owner(Member member) {
        this.members.add(member);
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public void display() {
        System.out.println(this.title + "   " + this.isbn);
    }

    public void displayMembers() {
        System.out.println("____________________________________________________________________________");
        System.out.println(this.title + "   " + this.isbn);
        if (members.size() != 0) {
            System.out.println("Name of members");
            for (Member member : members) {
                member.display();
            }
        } else {
            System.out.println("No records of members");
        }
        System.out.println("____________________________________________________________________________");
    }

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Book(Long id, String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
        this.id = id;
    }
}
