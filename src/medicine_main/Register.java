package medicine_main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register implements myMethods {

    private List<Account> registered = new ArrayList<Account>();
    Scanner user = new Scanner(System.in);
    private Account acc;

    public List<Account> getRegistered() {
        return registered;
    }

    public void setRegistered(List<Account> registered) {
        this.registered = registered;
    }

    public void addUser(Account acc) {
        registered.add(acc);
    }

    @Override
    public String input(String label) {
        System.out.print(label + ": ");
        return user.next();
    }

    @Override
    public int inputInt(String label) {
        System.out.print(label + ": ");
        return user.nextInt();
    }

    @Override
    public String addRole(String label) {
        if (label.equalsIgnoreCase("1")) {
            return "Admin";
        }
        return "Costumer";

    }

    public void toRegister() {
        System.out.println("\n-----------REGISTER ACCOUNT--------------\n");
        String role = input("Press any key for Costumer\n");
        String firstName = input("FirstName");
        String lastName = input("LastName");
        int Age = inputInt("Age");
        String Username = input("UserName");
        String Password = input("Password");
        System.out.println("");
        for (int i = 0; i < registered.size(); ++i) {
            if (Username.equals(getRegistered().get(i).getUsername())) {
                System.out.println("Username is already in used!!!\n");
                break;
            }else{
                addUser(new Account(addRole(role), firstName, lastName, Age, Username, Password));
                System.out.println("\nAccount created!!!\n");
                break;
            }
        }
    }

}
