/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_main;

import static medicine_main.Medicine_Main.med;
import static medicine_main.Medicine_Main.orderNum;
import static medicine_main.Medicine_Main.receipt;
import static medicine_main.Medicine_Main.user;

/**
 *
 * @author 2ndyrGroupB
 */
public class funtionalities {

    public static String input(String label) {
        System.out.print(label + ": ");
        return user.next();
    }

    public static int inputInt(String label) {
        System.out.print(label + ": ");
        return user.nextInt();
    }

    public static String addRole(String label) {
        if (label.equalsIgnoreCase("1")) {
            return "Admin";
        }
        return "Costumer";

    }

    public static void show(String illness) {
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int i = 0; i < med.size(); ++i) {
            Medicine current = med.get(i);
            if (current.getIllness().equalsIgnoreCase(illness)) {
                System.out.println(current);
            }
        }
    }

    public static void addMedicine(String illness) {
        if (illness.equalsIgnoreCase("cough") || illness.equalsIgnoreCase("allergies") || illness.equalsIgnoreCase("body pain") || illness.equalsIgnoreCase("headache")) {
            med.add(new Medicine(input("Medicine Name: "), input("Brand Name: "), input("Generic Name: "), inputInt("price: "), illness));
        } else {
            System.out.println("\nNo Storage for that medicine\n");
        }
    }

    public static void showPurchase(String name) {
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int i = 0; i < med.size(); ++i) {
            Medicine current = med.get(i);
            if (current.getMedDiscription().equalsIgnoreCase(name)) {
                System.out.println(current);
                receipt.add(current);
            }
        }
    }

    public static void printReceipt() {
        if (!receipt.isEmpty()) {
            System.out.println("-----------------------------------------------------Receipt------------------------------------------------");
            System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
            double payables = 0;
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.println(receipt.get(i));
                payables += ((receipt.get(i).getMedprice() * orderNum));
                System.out.println(receipt.get(i).getMedprice());
            }
            receipt.clear();
            System.out.println("\nTotal Payables(Pesos): " + payables);
            System.out.println("------------------------------------END OF TRANSACTION  |||||326548445678----------------------------------------------------\n");
        } else {
            System.out.println("Thank You!!!");
        }
    }

    public static void printReceiptDiscounted() {
        if (!receipt.isEmpty()) {
            System.out.println("-----------------------------------------------------Receipt------------------------------------------------");
            System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
            double payables = 0;
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.println(receipt.get(i));
                payables += ((receipt.get(i).getMedprice() * orderNum));
            }
            System.out.println("\nTotal Payables(Pesos): " + (payables - (payables * 0.15)));
            System.out.println("------------------------------------END OF TRANSACTION  |||||326548445678----------------------------------------------------\n");
        } else {
            System.out.println("Thank You!!!");
        }
    }
}
