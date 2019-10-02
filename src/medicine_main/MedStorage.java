
package medicine_main;

import java.util.ArrayList;
import java.util.List;

public class MedStorage {
    private  List<Medicine> med = new ArrayList<Medicine>();

    public List<Medicine> getMed() {
        return med;
    }

    public void setMed(List<Medicine> med) {
        this.med = med;
    }
    
    public void storeMedicine(Medicine medicine){
        med.add(medicine);
    }
}
