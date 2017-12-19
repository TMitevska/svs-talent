package twitter.service;

import twitter.model.Message;
import twitter.model.User;

import java.util.List;

public interface UserService {
    User signup(User user);
    User signin(String email,String password);
    boolean logout();
    Message tweet(Message message);
    User follow(String user);
    List<Message> list();

}
