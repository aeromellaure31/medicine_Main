
package medicine_main;

import java.util.ArrayList;
import java.util.List;

public class MedStorage {
    private  List<Medicine> medStorage = new ArrayList<Medicine>();

    public List<Medicine> getMedStorage() {
        return medStorage;
    }

    public void setMedStorage(List<Medicine> medStorage) {
        this.medStorage = medStorage;
    }
    
    public void storeMedicine(Medicine medicine){
        medStorage.add(medicine);
    }
}
