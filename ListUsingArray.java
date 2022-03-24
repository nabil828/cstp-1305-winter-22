import java.util.LinkedList;
import java.util.List;

// this is a list ADT as in the book
// we will start the list from position # 1
public class ListUsingArray {
    String [] arr = new String[10];

    int size = 0 ;
    void add(String a){
        arr[size + 1 ]= a;
        size++;
    }
    void add(int position, String a){
        if(position < size) {
            // shifting
            for (int i = size; i >= position; i--) {
                arr[i + 1] = arr[i];
            }
        }else
            throw new RuntimeException();

        arr[position] = a;
        size++;
    }


    void remove (int position){
        if(position < size) {
            // shifting
            for (int i = position ; i < size; i++) {
                arr[i] = arr[i + 1];
            }
        }

        size--;

    }

    String get (int position){
        return arr[position];
    }

    int get_size(){
        return  size;
    }

    public static void main(String[] args) {
        ListUsingArray obj = new ListUsingArray();
        obj.add("Buying Grociers");
        obj.add("Do the Laundry");
        obj.add("Study");
        obj.add("Sleep");
        obj.add(3, "eating");
        for(int i =1 ;i <= obj.get_size(); i++){
            System.out.println (obj.get(i));
        }
    }
}
