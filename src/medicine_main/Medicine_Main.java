package medicine_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Medicine_Main {

    public static HashMap<String, Integer> quantity = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Pharmacy pharma = new Pharmacy();
        MedStorage storage = new MedStorage();
        Register register = new Register();
        register.addUser(new Account("Costumer", "Aero", "Laure", 20, "aero", "mel"));
        register.addUser(new Account("Admin", "Aero", "Laure", 20, "admin", "admin"));

        //Medicine(GenericName,BrandName,MedDiscription,Medprice,illness)
        pharma.storeMedicine(new Medicine("Ascof-Forte", "Vitex negundo L.", "Ascof", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Ambroxol", "Ambroxol HCI", "RiteMed", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Ambrolex-Syrup", "Ambroxol", "Ambrolex", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Prolix", "Prednisone", "Prolix", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Headache"));
        pharma.storeMedicine(new Medicine("aero", "Prednisone", "Prolix", 100, "Headache"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Headache"));

        for (int i = 0; i < pharma.med.size(); ++i) {
            quantity.put(pharma.med.get(i).getMedDiscription(), 12);
        }

        int orderNum;
        boolean idn = true;
        Account currentUser = null;
        while (idn) {
            String choice = pharma.input("Press 1 to Register \nPress 2 to login\nPress 3 to Logout\nChoice");
            if (choice.equals("1")) {
                System.out.println("\n-----------REGISTER ACCOUNT--------------\n");
                String role = pharma.input("Press 1 for Admin\nPress any key Costumer\n");
                String firstName = pharma.input("FirstName");
                String lastName = pharma.input("LastName");
                int Age = pharma.inputInt("Age");
                String Username = pharma.input("UserName");
                String Password = pharma.input("Password");
                System.out.println("");
                register.addUser(new Account(pharma.addRole(role), firstName, lastName, Age, Username, Password));
            } else if (choice.equals("2")) {
                System.out.println("\n-----------LOGIN ACCOUNT--------------\n");
                String LoginuserName = pharma.input("Username");
                String LoginpassWord = pharma.input("Password");
                System.out.println("");

                for (int i = 0; i < register.registered.size(); ++i) {
                    Account acc = register.registered.get(i);
                    if (LoginuserName.equals(acc.getUsername()) && LoginpassWord.equals(acc.getPassword())) {
                        System.out.println("Welcome to Laure's Medic " + acc.getFirstname());
                        currentUser = acc;
                        String mainFuntion = "0";
                        while (mainFuntion != "5") {
                            mainFuntion = pharma.input("\n\nPress 1 View Medicine\nPress 2 Medicine Inventory(Admin)\nPress 3 Order Medicine\nPress 4 Add Medicine\nPress 5 Exit\n");
                            if (mainFuntion.equals("1")) {
                                System.out.println("\n-----------------------**************************LIST OF MEDICINES**************************---------------------------\n");
                                System.out.println("\n ****************************************************MEDICINE FOR COUGH*************************************************\n");
                                pharma.show("cough");
                                System.out.println("\n ****************************************************MEDICINE FOR ALLERGIES*************************************************\n");
                                pharma.show("Allergies");
                                System.out.println("\n ****************************************************MEDICINE FOR BODY PAIN*************************************************\n");
                                pharma.show("Body Pain");
                                System.out.println("\n ****************************************************MEDICINE FOR HEADACHE*************************************************\n");
                                pharma.show("Headache");
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
                                    System.out.println("\n--------------------------Order Now----------------------\n");
                                    String order = pharma.input("Medicine's Name");
                                    orderNum = pharma.inputInt("Quantity");
                                    pharma.payable(orderNum, order);
                                    if (quantity.containsKey(order)) {
                                        quantity.replace(order, quantity.get(order) - orderNum);
                                        System.out.println("\nYou're order will be delivered soonest!");
                                        pharma.showPurchase(order);
                                    } else {
                                        System.out.println("Can't find Medicine name");
                                        System.out.println("-------------------------------------------");
                                    }
                                }
                            } else if (mainFuntion.equals("4")) {
                                if (acc.getRole().equalsIgnoreCase("Admin")) {
                                    pharma.addMedicine(pharma.input("Medicine for: "));
                                } else {
                                    System.out.println("\nUnauthorized\n");
                                    System.out.println("---------------------------------------------------------\n");
                                }
                            } else if (mainFuntion.equals("5")) {
                                mainFuntion = "5";
                                if (currentUser.getAge() < 60) {
                                    pharma.printReceipt();
                                    break;
                                } else {
                                    pharma.printReceiptDiscounted();
                                    break;
                                }
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
