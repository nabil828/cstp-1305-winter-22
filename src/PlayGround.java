import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PlayGround {


        public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(12);
            numbers.add(8);
            numbers.add(2);
            numbers.add(23);
            Iterator<Integer> it = numbers.iterator();
//            while(it.hasNext()) {
//                Integer i = it.next();
//                if(i < 10) {
//                    it.remove();
//                }
//            }

            for(Integer x: numbers){
                if (x < 10){
                    numbers.remove(x);
                }
            }
            System.out.println(numbers);
        }

}