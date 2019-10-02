package medicine_main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register implements myMethods{

    public List<Account> registered = new ArrayList<Account>();
    public Scanner user = new Scanner(System.in);

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
        String role = input("Press 1 for Admin\nPress any key Costumer\n");
        String firstName = input("FirstName");
        String lastName = input("LastName");
        int Age = inputInt("Age");
        String Username = input("UserName");
        String Password = input("Password");
        System.out.println("");
        addUser(new Account(addRole(role), firstName, lastName, Age, Username, Password));
    }

}
