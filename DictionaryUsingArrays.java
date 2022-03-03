import java.util.Dictionary;
import java.util.Hashtable;

public class DictionaryUsingArrays {
    Pair arr []  = new Pair [10];
    int size = 0;
    void insert(String key, String value){
        if(!this.contains(key)){
            //insertion
            Pair newPair = new Pair(key, value);
            arr[size] = newPair;
            size++;
        }
        // else, nothing
    }

    void remove(String key){
        if(this.contains(key)){
            for(int i = 0; i < size ; i++) {
                if (arr[i].key == key)
                    arr[i] = arr[size - 1];
            }
            size--;
        }
        // else, nothing
    }

    void modify(String key, String value){
        for(int i = 0; i < size ; i++) {
            if (arr[i].key == key)
                arr[i].value = value;
            //modify
        }
    }

    String lookup(String key){
        for(int i = 0; i < size ; i++) {
            if (arr[i].key == key){
                return arr[i].value;
            }
            //modify
        }
        return "";
    }
    boolean contains(String key){
        for(int i = 0; i < size ; i++){
            if(arr[i].key == key)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {

        DictionaryUsingArrays aDictionary = new DictionaryUsingArrays(); // built-in Java dictionary
        aDictionary.insert("1234", "nabil");
        aDictionary.insert("5678", "renz"); // size should be two
        aDictionary.remove("1234");
        aDictionary.modify("5678", "renzo");
        System.out.println(aDictionary.lookup("5678")); //renzo

    }
}
