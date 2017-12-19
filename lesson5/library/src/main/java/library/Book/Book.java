package library.Book;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="title") private String title;
    @Column(name="isbn") private Long isbn;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Column(name="member")
    @ManyToMany(fetch=FetchType.EAGER,mappedBy="books")
    private List<Member> members=new LinkedList<Member>();
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
   public void display()
   {
       System.out.println(this.title+"   "+this.isbn );
   }
   public void displayMembers(){
       System.out.println("____________________________________________________________________________");
       System.out.println(this.title+"   "+this.isbn );
       if(members.size()!=0){
           System.out.println("Name of members");
           for(Member member:members)
           {
               member.display();
           }}
       else
       {System.out.println("No records of members");}
       System.out.println("____________________________________________________________________________");
   }
  public  Book(){}
   public Book(String title,Long isbn){this.title=title;this.isbn=isbn;
       Hibernate.initialize(members);}
}
