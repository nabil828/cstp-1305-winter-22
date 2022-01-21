import java.util.LinkedList;
import java.util.List;

public class ListPlayground {

    public static void main(String[] args) {
        List<String> obj = new LinkedList<>();
        obj.add("Buying Grociers");
        obj.add("Do the Laundry");
        obj.add("Study");
        obj.add("Sleep");
        obj.add(2, "eating");
        for(int i =0 ;i <obj.size(); i++){
            System.out.println (obj.get(i));
        }
    }
}
