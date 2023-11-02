package Model;

public class User {
    private String email;
    private String idNumber;
    private String name;
    private String password;


    public User(String email, String idNumber, String name, String password){
        this.email = email;
        this.idNumber = idNumber;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getidNumber() {
        return idNumber;
    }

    public void setidNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
