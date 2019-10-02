/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Pharmacy extends MedStorage implements myMethods{
    Account account;
    public Register register = new Register();
    double payables = 0;
    private List<Medicine> receipt = new ArrayList<Medicine>();
    private HashMap<String, Integer> quantity = new HashMap<String, Integer>();
    private Scanner user = new Scanner(System.in);

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

    public void show(String illness) {
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int i = 0; i < getMed().size(); ++i) {
            Medicine current = getMed().get(i);
            if (current.getIllness().equalsIgnoreCase(illness)) {
                System.out.println(current);
            }
        }
    }

    public void addMedicine(String illness) {
        if (illness.equalsIgnoreCase("cough") || illness.equalsIgnoreCase("allergies") || illness.equalsIgnoreCase("body pain") || illness.equalsIgnoreCase("headache")) {
            storeMedicine(new Medicine(input("Medicine Name: "), input("Brand Name: "), input("Generic Name: "), inputInt("price: "), illness));
        } else {
            System.out.println("\nNo Storage for that medicine\n");
        }
    }

    public void showPurchase(String name) {
        System.out.println("\n--------------------------***********************************Your Order***********************************--------------------------\n");
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int i = 0; i < getMed().size(); ++i) {
            Medicine current = getMed().get(i);
            if (current.getMedDiscription().equalsIgnoreCase(name)) {
                receipt.add(current);
                System.out.println(current);
            }
        }
        System.out.println("\n**********************************************************************************************************************************\n");
    }

    public void payable(int orderNum, String order) {
        for (int i = 0; i < getMed().size() - 1; ++i) {
            if (getMed().get(i).getMedDiscription().equals(order)) {
                payables += ((getMed().get(i).getMedprice() * orderNum));
            }
        }

    }

    public void printReceipt() {
        if (!receipt.isEmpty()) {
            System.out.println("-----------------------------------------------------Receipt------------------------------------------------");
            System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.println(receipt.get(i));
            }
            receipt.clear();
            System.out.println("\nTotal Payables(Pesos): " + payables);
            System.out.println("------------------------------------END OF TRANSACTION  |||||326548445678----------------------------------------------------\n");
        } else {
            System.out.println("Thank You!!!");
        }
    }

    public void printReceiptDiscounted() {
        if (!receipt.isEmpty()) {
            System.out.println("\n-----------------------------------------------------Receipt------------------------------------------------");
            System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.println(receipt.get(i));
            }
            System.out.println("\nTotal Payables(Pesos): " + (payables - (payables * 0.20)) + "            -----------discounted");
            System.out.println("------------------------------------END OF TRANSACTION  |||||9627318467----------------------------------\n\n");
        } else {
            System.out.println("Thank You!!!");
        }
    }

    public void increment() {
        register.addUser(new Account("Costumer", "Aero", "Laure", 20, "aero", "mel"));
        register.addUser(new Account("Admin", "Aero", "Laure", 20, "admin", "admin"));
        for (int i = 0; i < getMed().size(); ++i) {
            quantity.put(getMed().get(i).getMedDiscription(), 12);
        }
    }

    public void process() {
        increment();
        boolean idn = true;
        Account currentUser = null;
        while (idn) {
            String choice = input("Press 1 to Register \nPress 2 to login\nPress 3 to Exit\nChoice");
            if (choice.equals("1")) {
                register.toRegister();
            } else if (choice.equals("2")) {
                System.out.println("\n-----------LOGIN ACCOUNT--------------\n");
                String LoginuserName = input("Username");
                String LoginpassWord = input("Password");
                System.out.println("");

                for (int i = 0; i < register.getRegistered().size(); ++i) {
                    Account acc = register.getRegistered().get(i);
                    if (LoginuserName.equals(acc.getUsername()) && LoginpassWord.equals(acc.getPassword())) {
                        System.out.println("Welcome to Laure's Medic " + acc.getFirstname());
                        currentUser = acc;
                        String mainFuntion = "0";
                        while (mainFuntion != "5") {
                            mainFuntion = input("\n\nPress 1 View Medicine\nPress 2 Medicine Inventory(Admin)\nPress 3 Order Medicine\nPress 4 Add Medicine(Admin)\nPress 5 Logout\n");
                            if (mainFuntion.equals("1")) {
                                System.out.println("\n-----------------------**************************LIST OF MEDICINES**************************---------------------------\n");
                                System.out.println("\n ****************************************************MEDICINE FOR COUGH*************************************************\n");
                                show("cough");
                                System.out.println("\n ****************************************************MEDICINE FOR ALLERGIES*************************************************\n");
                                show("Allergies");
                                System.out.println("\n ****************************************************MEDICINE FOR BODY PAIN*************************************************\n");
                                show("Body Pain");
                                System.out.println("\n ****************************************************MEDICINE FOR HEADACHE*************************************************\n");
                                show("Headache");
                            } else if (mainFuntion.equals("2")) {
                                if (acc.getRole().equalsIgnoreCase("Admin")) {
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
                                    String order = input("Medicine's Name");
                                    int orderNum = inputInt("Quantity");
                                    payable(orderNum, order);
                                    if (quantity.containsKey(order)) {
                                        quantity.replace(order, quantity.get(order) - orderNum);
                                        System.out.println("\nYou're order will be delivered soonest!");
                                        showPurchase(order);
                                    } else {
                                        System.out.println("Can't find Medicine name");
                                        System.out.println("-------------------------------------------");
                                    }
                                }
                            } else if (mainFuntion.equals("4")) {
                                if (acc.getRole().equalsIgnoreCase("Admin")) {
                                    addMedicine(input("Medicine for: "));
                                } else {
                                    System.out.println("\nUnauthorized\n");
                                    System.out.println("---------------------------------------------------------\n");
                                }
                            } else if (mainFuntion.equals("5")) {
                                mainFuntion = "5";
                                if (currentUser.getAge() < 60) {
                                    printReceipt();
                                    break;
                                } else {
                                    printReceiptDiscounted();
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
