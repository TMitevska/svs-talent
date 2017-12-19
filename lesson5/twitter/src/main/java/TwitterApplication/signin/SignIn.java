package TwitterApplication.signin;

import TwitterApplication.Message.Message;
import TwitterApplication.Message.MessageRepository;
import TwitterApplication.User.User;
import TwitterApplication.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
public class SignIn {
    private UserRepository userrepository;
    private MessageRepository messagerepository;

    public SignIn() {
    }

    @Autowired
    public SignIn(UserRepository userrepo, MessageRepository messagerepo) {
        this.userrepository = userrepo;
        this.messagerepository = messagerepo;
    }

    public void signin() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter email:");
        String user = s.nextLine();
        System.out.println("Enter password:");
        String pass1 = s.nextLine();
        if (this.userrepository.finduser(user) != null) {
            if (this.userrepository.finduser(user).getPassword().equals(pass1)) {
                System.out.println("Logging in!");
                t1:
                while (true) {
                    System.out.println("Enter option 'tweet' , 'list' , 'follow' or 'log out' ");
                    String option = s.nextLine();
                    if (option.equals("tweet")) {
                        System.out.println("Enter message:");
                        String message = s.nextLine();
                        Message m = new Message(user, message);
                        this.messagerepository.save(m);
                    } else if (option.equals("list")) {
                        Iterable<User> users = this.userrepository.finduser(user).getFollowing();
                        for (User u : users) {
                            Iterable<Message> messages = this.messagerepository.findAll();
                            for (Message message : messages) {
                                if (message.getUser().equals(u.getEmail())) {
                                    message.display();
                                }
                            }
                        }
                    } else if (option.equals("follow")) {
                        System.out.println("Enter email:");
                        String email = s.nextLine();
                        if (this.userrepository.finduser(email) != null) {
                            User u = this.userrepository.findByEmail(email);
                            u.display();
                            User u2 = this.userrepository.findByEmail(user);
                            u2.display();
                            u2.follow(u);
                            u.following(u2);
                            this.userrepository.save(u);
                            this.userrepository.save(u2);


                        } else {
                            System.out.println("User doesn't exist!");
                        }
                    } else if (option.equals("log out")) {
                        System.out.println("Logging out ");
                        break t1;
                    }

                }

            } else {
                System.out.println("Wrong password!:");
            }
        } else {
            System.out.println("Invalid username");
        }
    }
}
