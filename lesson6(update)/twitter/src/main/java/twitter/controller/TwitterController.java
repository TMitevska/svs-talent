package twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twitter.model.Message;
import twitter.model.User;
import twitter.service.UserService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/twitters")
public class TwitterController {
    private UserService userservice;
    private final AtomicLong usercounter = new AtomicLong();
    private final AtomicLong messagecounter = new AtomicLong();
    private User loggeduser = null;

    @Autowired
    public TwitterController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping
    @RequestMapping("/signup/{email}")
    public User signup(@RequestParam(value = "email", defaultValue = " ") String email, @RequestParam(value = "password", defaultValue = " ") String pass1, @RequestParam(value = "confirmpassword", defaultValue = " ") String pass2) {
        if (pass1.equals(pass2)) {
            return this.userservice.signup(new User(usercounter.incrementAndGet(), email, pass1));
        } else {
            return null;
        }

    }

    @GetMapping
    @RequestMapping("/signin/{email}")
    public String signin(@RequestParam(value = "email", defaultValue = " ") String email, @RequestParam(value = "password", defaultValue = " ") String password) {
        loggeduser = this.userservice.signin(email, password);
        if (loggeduser != null) {
            return "User is logged in";
        } else {
            return "Wrong email or password";
        }
    }

    @GetMapping
    @RequestMapping("/logout")
    public String loggout() {
        this.userservice.logout();
        loggeduser = null;
        return "user is logged out";
    }

    @GetMapping
    @RequestMapping("/messages")
    public List<Message> listMessages() {
        return this.userservice.list();
    }

    @GetMapping
    @RequestMapping("/tweets")
    public Message tweet(@RequestParam(value = "message", defaultValue = " ") String message) {
        Message m=new Message(this.messagecounter.incrementAndGet(),this.loggeduser.getEmail(),message);
        m.display();
        return this.userservice.tweet(m);
    }
    @GetMapping
    @RequestMapping("/follows")
    public User follow(@RequestParam(value = "email", defaultValue = " ") String useremail)
    {
        return this.userservice.follow(useremail);
    }
}