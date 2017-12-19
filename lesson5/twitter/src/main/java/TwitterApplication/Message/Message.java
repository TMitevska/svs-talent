package TwitterApplication.Message;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message implements message {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "mail")
    private String user;
    @Column(name = "tweetmessage")
    private String message;

    public Message(String u, String m) {
        this.user = u;
        this.message = m;
    }

    public Message() {
    }

    public void display() {
        System.out.println(this.user + " says " + this.message);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
