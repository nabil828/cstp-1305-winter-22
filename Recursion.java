import java.util.Stack;

public class Recursion {

    static void countDown_iterative(int n){
        while(n > 0){
            System.out.println(n);
            n--;
        }
    }
    static void countUp_iterative(int n){
        int i = 1;
        while( i  <= n){
            System.out.println(i);
            i++;
        }
    }

    static void countDown_recursive(int n){
        System.out.println(n);

        if(n > 1){
            countDown_recursive(n-1);
        }
    }

    static void countUp_recursive(int n){
        if(n >= 1){
            countUp_recursive(n-1);
            System.out.println(n);
        }
    }

    public static int sumOf_iterative(int n){
        int sum = 0;
        for (int i = 1 ; i <= n ; i++ ){
            sum += i;
        }
        return  sum;
    }

    public static int sumOf_recursive(int n){
        if( n == 1){
            return  1;
        }else{
            return  n + sumOf_recursive(n-1);
        }

    }


    public static void displayArrayFromFirst_iterative(int array [], int first, int last){
        for(int i = first ; i <= last; i ++ ){
            System.out.println(array[i]);
        }
    }

    public static void displayArrayFromFirst_recursive(int array [], int first, int last){
        System.out.println(array[first]);
        if(first < last){
            displayArrayFromFirst_recursive(array, first + 1 , last);
        }
    }

    public static void displayArrayFromLast_recursive(int array [], int first, int last){
        System.out.println(array[last]);
        if(first < last){
            displayArrayFromLast_recursive(array, first  , last  - 1);
        }
    }
    public static void displayArrayFromLast_iterative(int array [], int first, int last){
        for(int i = last ; i >= first; i-- ){
            System.out.println(array[i]);
        }
    }

    public static  void displayArrayFromMiddle_recursive(int array [], int first, int last){
        if(first < 0 || last < 0 )
            return;
        if(first > last)
            return;
        if(first == last) {
            System.out.println(array[first]);
        }else{
            int middle = (first + last ) / 2;
            System.out.println(array[middle]);
            displayArrayFromMiddle_recursive(array, first, middle - 1);
            displayArrayFromMiddle_recursive(array, middle + 1, last);

        }
    }

    public static void displayListForward_iterative(Node head){
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }

    }

    public static void displayListBackward_iterative(Node head){
        Stack<Node> aStack = new Stack<Node>();
        //1- build a stack
        Node tmp = head;
        while(tmp != null){
//            System.out.println(tmp.data);
            aStack.push(tmp);
            tmp = tmp.next;
        }

        //empty stack
        while(!aStack.empty()){
            System.out.println(aStack.peek().data);
            aStack.pop();
        }

    }

    public static void displayListForward_recursive(Node head){

        System.out.println(head.data);
        if(head.next != null)
            displayListForward_recursive(head.next);

    }


    public static void displayListBackward_recursive(Node head){

        if(head.next != null)
            displayListBackward_recursive(head.next);
        System.out.println(head.data);


    }
    public static void main(String[] args) {
//        countDown_recursive(10); // 10, 9, 8, ... 1
//        countUp_recursive(10); // 1, 2, 3, ... 10
//        countUp_iterative(10); // 1, 2, 3, ... 10
//        System.out.println(sumOf_iterative(5)); // 1 + 2 + 3 + 4 + 5 = 1
//        System.out.println(sumOf_recursive(5)); // 1 + 2 + 3 + 4 + 5 = 15
        int []array = new int[5];
        array = new int []{5, 3, 2, 4, 1, 0};
//        displayArrayFromFirst_iterative(array, 0, 4); // 5, 3, 2, 4, 1;
//        displayArrayFromFirst_recursive(array, 0, 4); // 5, 3, 2, 4, 1;
//        displayArrayFromLast_iterative(array, 0, 4); // 1, 4, 2, 3, 5;
//        displayArrayFromLast_recursive(array, 0, 4); // 1, 4, 2, 3, 5;
//        displayArrayFromMiddle_recursive(array, 0, 5); // 2, 5, 3, 4, 1

        Node a = new Node();
        a.data = 5;


        Node b = new Node();
        b.data = 1;


        Node c = new Node();
        c.data = 3;
        a.next = b; b.next = c;
        // 5, 1, 3 frist to last
        // 3, 1, 5 last to first

        displayListBackward_iterative(a);  // 3, 1, 5 last to first


    }
}
