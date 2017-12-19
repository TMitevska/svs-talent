package twitter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import twitter.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select m from User m where m.email = ?1")
    User finduser(String email);

    User findByEmail(String email);
    User findUserById(Long id);
}
