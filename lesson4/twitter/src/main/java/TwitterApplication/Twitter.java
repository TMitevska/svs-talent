package TwitterApplication;

import User.User;
import Message.Message;
import Messages.Messages;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Scanner;
@SpringBootApplication
public class Twitter {

    public static void main(String[] argc) {
        Hashtable<String, User> table = new Hashtable<String, User>();
        Scanner s = new Scanner(System.in);
        ApplicationContext context= SpringApplication.run(Twitter.class,argc);

        String option;
        Messages list= context.getBean(Messages.class);
        t2:
        while (true) {
            System.out.println("Enter option 'sign up' , 'log in' or 'exit' ");
            option = s.nextLine();
            if (option.toLowerCase().equals("sign up")) {
                System.out.println("Enter username:");
                String user = s.nextLine();
                System.out.println("Enter password:");
                String pass1 = s.nextLine();
                System.out.println("Confirm password:");
                String pass2 = s.nextLine();
                if ((!table.containsKey(user)) && pass1.equals(pass2)) {
                    User twiteruser = new User(user, pass1);
                    table.put(user, twiteruser);
                    System.out.println("Correct");
                } else {
                    if (!table.containsKey(user)) {
                        System.out.println("Username is not unique!");
                    } else {
                        System.out.println("Passwords don't match");
                    }
                }
            } else if (option.toLowerCase().equals("log in")) {
                System.out.println("Enter username:");
                String user = s.nextLine();
                System.out.println("Enter password:");
                String pass1 = s.nextLine();
                if (table.containsKey(user)) {
                    if (table.get(user).getPassword().equals(pass1)) {
                        System.out.println("Logging in!");
                        t1:
                        while (true) {
                            System.out.println("Enter option 'tweet' , 'list' or 'exit' ");
                            option = s.nextLine();
                            if (option.equals("tweet")) {
                                System.out.println("Enter message:");
                                String message = s.nextLine();
                                list.add(new Message(new User(user, pass1), message));
                            } else if (option.equals("list")) {
                                list.list();

                            } else if (option.equals("exit")) {
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
            } else if (option.toLowerCase().equals("exit")) {
                System.out.print("Exit");
                break t2;
            }


        }
    }
}
