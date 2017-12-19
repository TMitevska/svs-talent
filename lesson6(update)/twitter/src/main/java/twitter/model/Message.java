package twitter.model;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    private Long id;
    @Column(name = "mail")
    private String user;
    @Column(name = "message")
    private String message;

    public Message(String u, String m) {
        this.user = u;
        this.message = m;
    }
    public Message(Long id,String u, String m) {
        this.user = u;
        this.message = m;
        this.id=id;
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
    public String toString() {
        return this.id+"   "+this.user+"  "+this.message;
    }

}
