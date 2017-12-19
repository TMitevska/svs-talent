package twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter.model.Message;
import twitter.model.User;
import twitter.repository.MessageRepository;
import twitter.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class userService implements UserService {

    private UserRepository userrepository;
    private MessageRepository messageRepository;
    private  Long loggedUser ;
    @Autowired
    public userService(UserRepository userrepo,MessageRepository messagerepo){this.loggedUser=null;this.userrepository=userrepo;this.messageRepository=messagerepo;}

    @Override
    public User signup(User user)
    {
       return this.userrepository.save(user);
    }
    public User signin(String email,String password)
    {   User user=this.userrepository.findByEmail(email);
        if(user!=null && user.getPassword().equals(password))
        { loggedUser=user.getId();
        return user;}
        else
        {
            return null;
        }
    }
    @Override
    public boolean logout()
    {
        this.loggedUser=null;
        return true;
    }
    @Override
    public Message tweet(Message message)
    {
        return this.messageRepository.save(message);
    }
    @Override
    public User follow(String u)
    {
        if(loggedUser!=null)
        {
            User loggeduser=this.userrepository.findUserById(this.loggedUser);
            User user=this.userrepository.findByEmail(u);
            loggeduser.follow(user);
            user.followed(loggeduser);
            this.userrepository.save(loggeduser);
            this.userrepository.save(user);
            return loggeduser;
        }
        else
        {
            return null;
        }
    }
    @Override
    public List<Message> list()
    {   List<Message> list=new LinkedList<Message>();
        List<User> users=this.userrepository.findUserById(loggedUser).getFollowing();
        for(User user:users){
        for(Message message:this.messageRepository.findAll())
        {
            if(message.getUser().equals(user.getEmail()))
            {
                list.add(message);
            }

        }
    }
    return list;
    }

}
