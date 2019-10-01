
package medicine_main;

import java.util.ArrayList;
import java.util.List;

public class MedStorage {
    public  List<Medicine> med = new ArrayList<Medicine>();
    
    public void storeMedicine(Medicine medicine){
        med.add(medicine);
    }
}
