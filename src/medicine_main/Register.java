
package medicine_main;

import java.util.ArrayList;
import java.util.List;

public class Register {
    public List<Account> registered = new ArrayList<Account>();
    
    public void addUser(Account acc){
        registered.add(acc);
    }
   
}
