package twitter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import twitter.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
    @Query("select m from Message m where m.user= ?1")
    Message findmessage(String user);
    Message findMessageByUser(String username);

}
