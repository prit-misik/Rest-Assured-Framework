package pojo;

public class User {

    private String name;
    private String status;
    private String gender;
    private String email;

    // a constructor creates immutable object
    public User(String name, String status, String gender, String email) {
        this.name = name;
        this.status = status;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

}
