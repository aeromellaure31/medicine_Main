
package medicine_main;

public class Account {

    private String role;
    private String Firstname;
    private String Lastname;
    private int Age;
    private String Username;
    private String Password;

    public Account(String role, String Firstname, String Lastname, int Age, String Username, String Password) {
        this.role = role;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Age = Age;
        this.Username = Username;
        this.Password = Password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
