/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pharmacy extends MedStorage {

    double payables = 0;
    public List<Medicine> receipt = new ArrayList<Medicine>();
    public Scanner user = new Scanner(System.in);

    public String input(String label) {
        System.out.print(label + ": ");
        return user.next();
    }

    public int inputInt(String label) {
        System.out.print(label + ": ");
        return user.nextInt();
    }

    public String addRole(String label) {
        if (label.equalsIgnoreCase("1")) {
            return "Admin";
        }
        return "Costumer";

    }

    public void show(String illness) {
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int i = 0; i < med.size(); ++i) {
            Medicine current = med.get(i);
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
        for (int i = 0; i < med.size(); ++i) {
            Medicine current = med.get(i);
            if (current.getMedDiscription().equalsIgnoreCase(name)) {
                receipt.add(current);
                System.out.println(current);
            }
        }
        System.out.println("\n**********************************************************************************************************************************\n");
    }

    public void payable(int orderNum, String order) {
        payables += ((receipt.get(med.indexOf(order)).getMedprice() * orderNum));

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
}
