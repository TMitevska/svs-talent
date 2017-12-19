package library.Book;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>{
    @Query("select b from Book b where b.title = ?1")
    Book findbook(String title);

}

