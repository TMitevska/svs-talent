package twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User  {
    @Id
    private Long id;
    @Column(name = "email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    @Column(name = "password")

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonIgnore
    @Column(name = "followers")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "following")
    private List<User> followers = new LinkedList<User>();
    @JsonIgnore
    @Column(name = "following")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_follower", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user2_id", referencedColumnName = "id"))
    private List<User> following = new LinkedList<User>();

    public User() {
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public User(String email, String password) {
        this.password = password;
        this.email = email;
    }
    public User(Long id,String email, String password) {
        this.password = password;
        this.email = email;
        this.id=id;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String display() {
        return "TwitterApplication.User:  " + this.email;
    }

    public void follow(User user) {
        this.following.add(user);
    }

    public void followed(User user) {
        this.followers.add(user);
    }
}
