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

public class Pharmacy extends MedStorage implements myMethods {

    private Account account;
    private double payables = 0;
    private Register register = new Register();
    private List<Medicine> receipt = new ArrayList<Medicine>();
//    private List<Medicine> allMedicine = new ArrayList<Medicine>();
    private HashMap<String, Integer> medQuantity = new HashMap<String, Integer>();
    private Scanner user = new Scanner(System.in);
    private Medicine medicine;
    private List list = new ArrayList();

//    public List<Medicine> getAllMedicine() {
//        return allMedicine;
//    }
//
//    public void setAllMedicine(List<Medicine> allMedicine) {
//        this.allMedicine = allMedicine;
//    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getPayables() {
        return payables;
    }

    public void setPayables(double payables) {
        this.payables = payables;
    }

    public List<Medicine> getReceipt() {
        return receipt;
    }

    public void setReceipt(List<Medicine> receipt) {
        this.receipt = receipt;
    }

    public HashMap<String, Integer> getMedQuantity() {
        return medQuantity;
    }

    public void setMedQuantity(HashMap<String, Integer> medQuantity) {
        this.medQuantity = medQuantity;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
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

    public void show(String illness) {
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int i = 0; i < getMedStorage().size(); ++i) {
            Medicine current = getMedStorage().get(i);
            if (current.getIllness().equalsIgnoreCase(illness)) {
                System.out.println(current);
            }
        }
    }

    public void deleteMedicine() {
        if (account.getRole().equalsIgnoreCase("Admin")) {
            String toBeDeleted = (input("\nMedicine name to be delete: "));
            for (int i = 0; i < getMedStorage().size(); ++i) {
                if (toBeDeleted.equals(getMedStorage().get(i).getMedName())) {
                    getMedStorage().remove(getMedStorage().indexOf(getMedStorage().get(i)));
                    System.out.println("\nMedicine deleted!!!\n");
                }
            }
        } else {
            System.out.println("\nUnauthorized\n");
            System.out.println("---------------------------------------------------------\n");
        }
    }

    public void addMedicine() {
        if (account.getRole().equalsIgnoreCase("Admin")) {
            String illness = (input("Medicine for: "));
            if (illness.equalsIgnoreCase("cough") || illness.equalsIgnoreCase("allergies") || illness.equalsIgnoreCase("body pain") || illness.equalsIgnoreCase("headache")) {
                storeMedicine(new Medicine(input("Medicine Name: "), input("Brand Name: "), input("Generic Name: "), inputInt("price: "), illness));
            } else {
                System.out.println("\nNo Storage for that medicine\n");
            }
        } else {
            System.out.println("\nUnauthorized\n");
            System.out.println("---------------------------------------------------------\n");
        }
    }

    public void showPurchase(String name) {
        System.out.println("\n--------------------------***********************************Your Order***********************************--------------------------\n");
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int i = 0; i < getMedStorage().size(); ++i) {
            Medicine current = getMedStorage().get(i);
            if (current.getMedName().equalsIgnoreCase(name)) {
                System.out.println(current);
                receipt.add(current);
            }

        }
        System.out.println("\n**********************************************************************************************************************************\n");
    }

//    public void showAllPurchase() {
//        System.out.println("\n-----------------------------------------------------All Orders------------------------------------------------");
//        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "|", "Quantity", "\n");
//        for (int i = 0; i < allMedicine.size(); ++i) {
//            System.out.println(allMedicine.get(i));
//        }
//        System.out.println("\n**********************************************************************************************************************************\n");
//    }
    public void payable(int orderNum, String order) {
        for (int i = 0; i < getMedStorage().size() - 1; ++i) {
            if (getMedStorage().get(i).getMedName().equals(order)) {
                payables += ((getMedStorage().get(i).getMedprice() * orderNum));
            }
        }

    }

    public void printReceipt() {
        if (!receipt.isEmpty()) {
            System.out.println("----------------------Receipt------------------------");
            System.out.printf("%s %34s", "Medicine Name", "Quantity Ordered\n\n");
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.printf("%s %30s", receipt.get(i).getMedName(), list.get(i));
                System.out.println("");
            }
            receipt.clear();
            System.out.println("\nTotal Payables(Pesos): " + payables);
            System.out.println("------------------------------------END OF TRANSACTION  |||||326548445678----------------------------------------------------\n");
        } else {
            System.out.println("\nThank You!!!\n");
        }
    }

    public void printReceiptDiscounted() {
        if (!receipt.isEmpty()) {
            System.out.println("----------------------Receipt------------------------");
            System.out.printf("%s %34s", "Medicine Name", "Quantity Ordered\n\n");
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.printf("%s %30s", receipt.get(i).getMedName(), list.get(i));
                System.out.println("");
            }
            receipt.clear();
            System.out.println("\nPayables(Pesos): " + payables);
            System.out.println("----------------------------------------\nDiscount: " + (payables * 0.20));
            System.out.println("----------------------------------------\nTotal Payables(Pesos): " + (payables - (payables * 0.20)));
            System.out.println("--------------------------------------------END OF TRANSACTION  |||||9627318467------------------------------------------\n\n");
        } else {
            System.out.println("\nThank You!!!\n");
        }
    }

    public void increment() {
        register.addUser(new Account("Costumer", "Aero", "Laure", 20, "aero", "mel"));
        register.addUser(new Account("Admin", "Aero", "Laure", 20, "admin", "admin"));
        for (int i = 0; i < getMedStorage().size(); ++i) {
            medQuantity.put(getMedStorage().get(i).getMedName(), 50);
        }
    }

    public void inventory() {
        if (account.getRole().equalsIgnoreCase("Admin")) {
            System.out.println("------------------------------------INVENTORY----------------------------------\n");
            medQuantity.forEach((k, v) -> System.out.println("Medicine: " + k + "\twith Quantity:" + v + "\n"));
            System.out.println("-------------------------------------------------------------------------------\n");
        } else {
            System.out.println("\nUnauthorized\n");
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    public void viewOrder() {
        System.out.println("\n-----------------------------------------------------Your Order---------------------------------------------------------");
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int x = 0; x < receipt.size(); ++x) {
            System.out.println(receipt.get(x));
        }
    }

    public void process() {
        increment();
        boolean condition = true;
        Account currentUser = null;
        while (condition) {
            String choice = input("Press 1 to Register \nPress 2 to login\nPress 3 to Exit\nChoice");
            switch (choice) {
                case "1":
                    register.toRegister();
                case "2":
                    System.out.println("\n-----------LOGIN ACCOUNT--------------\n");
                    String LoginuserName = input("Username");
                    String LoginpassWord = input("Password");
                    System.out.println("");

                    for (int i = 0; i < register.getRegistered().size(); ++i) {
                        account = register.getRegistered().get(i);
                        if (LoginuserName.equals(account.getUsername()) && LoginpassWord.equals(account.getPassword())) {
                            if (account.getRole().equalsIgnoreCase("Admin")) {
                                System.out.println("Welcome pharmacist " + account.getFirstname());
                                String mainFuntion = "0";
                                while (mainFuntion != "7") {
                                    mainFuntion = input("\n\nPress 1 View Medicine\nPress 2 Medicine Inventory\nPress 3 Order Medicine\nPress 4 Add Medicine\nPress 5 View Order\nPress 6 Delete Medicine\nPress 7 Logout\n");
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
                                        inventory();
                                    } else if (mainFuntion.equals("3")) {
                                        if (account.getAge() < 18) {
                                            System.out.println("\nYou can only View Medicine");
                                        } else {
                                            System.out.println("\nTo purchase Follow how the medicine is being written *****Thank You*****");
                                            System.out.println("\n--------------------------Order Now----------------------\n");
                                            String order = input("Medicine's Name");
                                            int orderNum = inputInt("Quantity");
                                            payable(orderNum, order);
                                            if (medQuantity.containsKey(order)) {
                                                if (orderNum <= medQuantity.get(order)) {
                                                    list.add(orderNum);
                                                    medQuantity.replace(order, medQuantity.get(order) - orderNum);
                                                    System.out.println("\nYou're order will be delivered soonest!");
                                                    showPurchase(order);
//                                                    for (int z = 0; z < getMedStorage().size(); ++z) {
//                                                        Medicine med = getMedStorage().get(z);
//                                                        if (order.equals(med.getMedDiscription())) {
//                                                            allMedicine.add(med);
//                                                        }
//                                                    }
                                                } else {
                                                    System.out.println("Insufficient medicine!!!");
                                                }
                                            } else {
                                                System.out.println("Can't find Medicine name");
                                                System.out.println("-------------------------------------------");
                                            }
                                        }
                                    } else if (mainFuntion.equals("4")) {
                                        addMedicine();
                                    } else if (mainFuntion.equals("5")) {
                                        if (account.getAge() < 18) {
                                            System.out.println("\nYou can only View Medicine");
                                        } else {
                                            viewOrder();
                                        }
                                    } else if (mainFuntion.equals("6")) {
                                        deleteMedicine();
                                    } else if (mainFuntion.equals("7")) {
                                        mainFuntion = "7";
                                        if (account.getAge() < 65) {
                                            printReceipt();
                                            payables = 0;
                                            list.clear();
                                            break;
                                        } else {
                                            printReceiptDiscounted();
                                            payables = 0;
                                            list.clear();
                                            break;
                                        }
                                    } else {
                                        System.out.println("Invalid input");

                                    }
                                }
                            } else {
                                System.out.println("Welcome to Laure's Medic " + account.getFirstname());
                                String mainFuntion = "0";
                                while (mainFuntion != "4") {
                                    mainFuntion = input("\n\nPress 1 View Medicine\nPress 2 Order Medicine\nPress 3 View Order\nPress 4 Logout\n");
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
                                        if (account.getAge() < 18) {
                                            System.out.println("\nYou can only View Medicine");
                                        } else {
                                            System.out.println("\nTo purchase Follow how the medicine is being written *****Thank You*****");
                                            System.out.println("\n--------------------------Order Now----------------------\n");
                                            String order = input("Medicine's Name");
                                            int orderNum = inputInt("Quantity");
                                            payable(orderNum, order);
                                            if (medQuantity.containsKey(order)) {
                                                if (orderNum <= medQuantity.get(order)) {
                                                    list.add(orderNum);
                                                    medQuantity.replace(order, medQuantity.get(order) - orderNum);
                                                    System.out.println("\nYou're order will be delivered soonest!");
                                                    showPurchase(order);
                                                } else {
                                                    System.out.println("Insufficient medicine!!!");
                                                }
                                            } else {
                                                System.out.println("Can't find Medicine name");
                                                System.out.println("-------------------------------------------");
                                            }
                                        }
                                    } else if (mainFuntion.equals("3")) {
                                        if (account.getAge() < 18) {
                                            System.out.println("\nYou can only View Medicine");
                                        } else {
                                            viewOrder();
                                        }
                                    } else if (mainFuntion.equals("4")) {
                                        mainFuntion = "4";
                                        if (account.getAge() < 65) {
                                            printReceipt();
                                            payables = 0;
                                            list.clear();
                                            break;
                                        } else {
                                            printReceiptDiscounted();
                                            payables = 0;
                                            list.clear();
                                            break;
                                        }
                                    } else {
                                        System.out.println("Invalid input");

                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;
                case "3":
                    condition = false;
                    System.out.println("Thank You ----- Come Again");
                    break;
                default:
                    System.out.println("\ninvalid input\n");
            }
        }
    }
}
