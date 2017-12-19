package TwitterApplication.signup;

import TwitterApplication.User.User;
import TwitterApplication.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SignUp {
    private UserRepository userrepository;

    public SignUp() {
    }

    @Autowired
    public SignUp(UserRepository userrepository) {
        this.userrepository = userrepository;
    }

    public void signup() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter email:");
        String email = s.nextLine();
        System.out.println("Enter password:");
        String pass1 = s.nextLine();
        System.out.println("Confirm password:");
        String pass2 = s.nextLine();
        if (this.userrepository.finduser(email) == null && pass1.equals(pass2)) {
            this.userrepository.save(new User(email, pass1));
            System.out.println("Correct");
        } else {
            if (this.userrepository.finduser(email) != null) {
                System.out.println("Email is not unique!");
            } else {
                System.out.println("Passwords don't match");
            }
        }
    }

}
