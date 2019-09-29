package medicine_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Medicine_Main {

    public static Scanner user = new Scanner(System.in);
    public static List<Account> registered = new ArrayList<Account>();
    public static List<Medicine> med = new ArrayList<Medicine>();
    public static List<Medicine> receipt = new ArrayList<Medicine>();
    public static HashMap<String, Integer> quantity = new HashMap<String, Integer>();
    static int orderNum;

    public static void main(String[] args) {
        funtionalities func = new funtionalities();
        registered.add(new Account("Costumer", "Aero", "Laure", 20, "aero", "mel"));
        registered.add(new Account("Admin", "Aero", "Laure", 20, "admin", "admin"));

        //Medicine(GenericName,BrandName,MedDiscription,Medprice,illness)
        med.add(new Medicine("Ascof-Forte", "Vitex negundo L.", "Ascof", 100, "Cough"));
        med.add(new Medicine("Ambroxol", "Ambroxol HCI", "RiteMed", 100, "Cough"));
        med.add(new Medicine("Ambrolex-Syrup", "Ambroxol", "Ambrolex", 100, "Cough"));
        med.add(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        med.add(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        med.add(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        med.add(new Medicine("Prolix", "Prednisone", "Prolix", 100, "Body Pain"));
        med.add(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Body Pain"));
        med.add(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Body Pain"));
        med.add(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Headache"));
        med.add(new Medicine("aero", "Prednisone", "Prolix", 100, "Headache"));
        med.add(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Headache"));

        for (int i = 0; i < med.size(); ++i) {
            quantity.put(med.get(i).getMedDiscription(), 12);
        }

        boolean idn = true;
        Account currentUser = null;
        while (idn) {
            String choice = func.input("Press 1 to Register \nPress 2 to login\nPress 3 to Logout\nChoice");
            if (choice.equals("1")) {
                System.out.println("\n-----------REGISTER ACCOUNT--------------\n");
                String role = func.input("Press 1 for Admin\nPress any key Costumer\n");
                String firstName = func.input("FirstName");
                String lastName = func.input("LastName");
                int Age = func.inputInt("Age");
                String Username = func.input("UserName");
                String Password = func.input("Password");
                System.out.println("");
                registered.add(new Account(func.addRole(role), firstName, lastName, Age, Username, Password));
            } else if (choice.equals("2")) {
                System.out.println("\n-----------LOGIN ACCOUNT--------------\n");
                String LoginuserName = func.input("Username");
                String LoginpassWord = func.input("Password");
                System.out.println("");

                for (int i = 0; i < registered.size(); ++i) {
                    Account acc = registered.get(i);
                    if (LoginuserName.equals(acc.getUsername()) && LoginpassWord.equals(acc.getPassword())) {
                        System.out.println("Welcome to Laure's Medic " + acc.getFirstname());
                        currentUser = acc;
                        String mainFuntion = "0";
                        while (mainFuntion != "5") {
                            mainFuntion = func.input("\n\nPress 1 View Medicine\nPress 2 Medicine Inventory(Admin)\nPress 3 Order Medicine\nPress 4 Add Medicine\nPress 5 Exit\n");
                            if (mainFuntion.equals("1")) {
                                System.out.println("\n-----------------------**************************LIST OF MEDICINES**************************---------------------------\n");
                                System.out.println("\n ****************************************************MEDICINE FOR COUGH*************************************************\n");
                                func.show("cough");
                                System.out.println("\n ****************************************************MEDICINE FOR ALLERGIES*************************************************\n");
                                func.show("Allergies");
                                System.out.println("\n ****************************************************MEDICINE FOR BODY PAIN*************************************************\n");
                                func.show("Body Pain");
                                System.out.println("\n ****************************************************MEDICINE FOR HEADACHE*************************************************\n");
                                func.show("Headache");
                            } else if (mainFuntion.equals("2")) {
                                if (acc.getRole().equalsIgnoreCase("Admin")) {
                                    //Medquantity.forEach(null);
                                    System.out.println("------------------------------------INVENTORY----------------------------------\n");
                                    quantity.forEach((k, v) -> System.out.println("Medicine: " + k + "\twith Quantity:" + v + "\n"));
                                    System.out.println("-------------------------------------------------------------------------------\n");
                                } else {
                                    System.out.println("\nUnauthorized\n");
                                    System.out.println("-----------------------------------------------------------\n");
                                }
                            } else if (mainFuntion.equals("3")) {
                                if (currentUser.getAge() < 18) {
                                    System.out.println("\nYou can only View Medicine");
                                } else {
                                    System.out.println("--------------------------Order Now----------------------");
                                    String order = func.input("Medicine's Name");
                                    orderNum += func.inputInt("Quantity");
                                    if (quantity.containsKey(order)) {
                                        quantity.replace(order, quantity.get(order) - orderNum);
                                        System.out.println("You're order will be delivered soonest!");
                                        func.showPurchase(order);
                                    } else {
                                        System.out.println("Can't find Medicine name");
                                    }
                                }
                            } else if (mainFuntion.equals("4")) {
                                if (acc.getRole().equalsIgnoreCase("Admin")) {
                                    func.addMedicine(func.input("Medicine for: "));
                                } else {
                                    System.out.println("\nUnauthorized\n");
                                    System.out.println("---------------------------------------------------------\n");
                                }
                            } else if (mainFuntion.equals("5")) {
                                mainFuntion = "5";
                                System.out.println(orderNum);
                                if (currentUser.getAge() < 60) {
                                    func.printReceipt();
                                } else {
                                    func.printReceiptDiscounted();
                                }
                                break;
                            } else {
                                System.out.println("Invalid");
                            }
                        }
                        break;
                    }
                }
            } else if (choice.equals("3")) {
                idn = false;
                System.out.println("Thank You ----- Come Again");
                break;
            } else {
                System.out.println("\ninvalid input\n");
            }
        }

    }
}
