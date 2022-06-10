import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    public ArrayList<String> arrayString = new ArrayList<>();
    public HashMap<Integer, String> arrayMenu = new HashMap<>();

    public Menu() {}

    //Menu builder methods creates menu in terminal according to arrayMenu Strings and arrayMenu.size() (length)
    public void menuBuilder(){
        int i = 1;
        //Filling arrayList for menu creating
        for(String o: arrayString){
            arrayMenu.put(i, o);
            i++;
        }
        arrayMenu.forEach((n,s) -> System.out.println(n+") "+s));
    }

}
