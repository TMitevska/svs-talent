package TwitterApplication;


import TwitterApplication.Message.MessageRepository;
import TwitterApplication.User.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import TwitterApplication.signin.SignIn;
import TwitterApplication.signup.SignUp;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories
public class Twitter {

    public static void main(String[] argc) {
        Scanner s = new Scanner(System.in);
        String option;
        ConfigurableApplicationContext context = SpringApplication.run(Twitter.class, argc);
        UserRepository userrepo = context.getBean(UserRepository.class);
        MessageRepository messagerepo = context.getBean(MessageRepository.class);
        t2:
        while (true) {
            System.out.println("Enter option 'sign up' , 'sign in' or 'exit' ");
            option = s.nextLine();
            if (option.toLowerCase().equals("sign up")) {
                new SignUp(userrepo).signup();
            } else if (option.toLowerCase().equals("sign in")) {
                new SignIn(userrepo, messagerepo).signin();
            } else if (option.toLowerCase().equals("exit")) {
                System.out.print("Exit");
                break t2;

            }


        }
    }
}
