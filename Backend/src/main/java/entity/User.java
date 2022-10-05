package entity;


public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private int age;

    public User(){}

    public User(int id, String firstname, String lastname, String username, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id:" + getId() + System.lineSeparator() +  "firstname:" + getFirstname() + System.lineSeparator() +  "lastname:" + getLastname() + System.lineSeparator() + "username:" + getUsername() + System.lineSeparator() + "age:" + getAge() + System.lineSeparator();
    }
}
