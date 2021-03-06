package library.Book;


import library.Book.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Long> {
    @Query("select m from Member m where m.name = ?1")
    Member findmember(String name);
}

