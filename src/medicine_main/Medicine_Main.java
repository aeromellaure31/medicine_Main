package medicine_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Medicine_Main {

    public static void main(String[] args) {
        Pharmacy pharma = new Pharmacy();
        MedStorage storage = new MedStorage();
        pharma.storeMedicine(new Medicine("Ascof-Forte", "Vitex-negundo L.", "Ascof", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Ambroxol", "Ambroxol-HCI", "RiteMed", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Ambrolex", "Ambroxol", "Ambrolex-Syrup", 100, "Cough"));
        pharma.storeMedicine(new Medicine("Prolix", "Prednisone", "Prolix-Suspension", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Solcoseryl", "Solcoseryl-Ointment", "Deproteinized", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Drixine", "Drixine-Pedia-Drops", "Oxymetazoline Hydrochloride", 100, "Allergies"));
        pharma.storeMedicine(new Medicine("Advil", "Advil-Suspension", "Ibuprofen", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Naproxen", "Naproxen-Sodium", "Naproxen", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Cilostazol", "PLETAAL", "Pletaal", 100, "Body Pain"));
        pharma.storeMedicine(new Medicine("Tempra-Drops", "Paracetamol", "Tempra", 100, "Headache"));
        pharma.storeMedicine(new Medicine("Tempra-Forte", "Paracetamol", "Tempra", 100, "Headache"));
        pharma.storeMedicine(new Medicine("Flixotide-Inhaler", "Fluticasone", "Flixotide", 100, "Headache"));
        pharma.process();
    }
}
