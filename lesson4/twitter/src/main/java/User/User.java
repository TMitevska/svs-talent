package User;

public class User implements user{
    private String username;
    private String password;
    public User(String username,String password){this.password=password;this.username=username;}
    public void setPassword(String password){this.password=password;}
    public String getPassword(){return this.password;}
    public String display(){return "User.User:  "+this.username;}
}
