package medicine_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Medicine_Main {

    public static void main(String[] args) {
        Pharmacy pharma = new Pharmacy();
        MedStorage storage = new MedStorage();
        pharma.storeMedicine(new Medicine("Ascof-Forte", "Vitex negundo L.", "Ascof", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Ambroxol", "Ambroxol HCI", "RiteMed", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Ambrolex-Syrup", "Ambroxol", "Ambrolex", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Solcoseryl-Ointment", "Solcoseryl", "Deproteinized", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Prolix", "Prednisone", "Prolix", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Headache"));
        pharma.storeMedicine(new Medicine("aero", "Prednisone", "Prolix", 100, "Headache"));
        pharma.storeMedicine(new Medicine("Prolix-Suspension", "Prednisone", "Prolix", 100, "Headache"));
        pharma.process();
    }
}
