package Message;

import User.User;
import org.springframework.stereotype.Component;

@Component
public class Message implements message{

private User user;
private String message;
public Message(User u,String m){this.user=u;this.message=m;}
public String display(){return user.display()+" says "+this.message;}
}
