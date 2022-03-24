public class PQUsingArrays implements PQInterface{

    int []arr = new int[100]; // bad design
    int size = 0; // should do the inilization in the constuctor

    // stub function
    public void add(int a ){
        if(size == 0)
            arr[size++] = a;

        // 1 - find the position
        //        // [1, 2, 5, 6, 10]
        //        aPriorityQueue.add(4);
        int i = 0;
        while(a > arr[i] && i < size - 1){
            i++;
        }
        int position = i;

        // 2 - shift
        // Goal: // [1, 2, ,5]
        int j = size-1; // size-1 last element that we have inserted to the array
            // until you reach j=i
        while(j >= i){
            arr[j+1] = arr[j];

            j--;
        }

        // 3 - insert
        arr[i] = a;
        size++;
    }

    public Integer peek(){
        if(size ==0)
            return  null;
        return  arr[0];
    }

    public Integer remove(){

        if(size ==0)
            return  null;

        int j = 0;
        //        [1, 2, 5] size = 3
        // [2, 5]
        while(j < size-1){
            arr[j] = arr[j+1];

            j++;
        }
        return arr[j];
    }

    public boolean contains(int a){

        return false;
    }




    // driver code
    public static void main(String[] args) {
        PQInterface aPriorityQueue = new PQUsingArrays();
        aPriorityQueue.peek(); // null
        //5, 4, 2, 1, -7
        aPriorityQueue.add(1);
        aPriorityQueue.add(5);
        aPriorityQueue.add(2);
        // [1, 2, 5]
        aPriorityQueue.add(4); // find position - index 2 -   shift and insert
        // [1, 2, 4, 5]
        aPriorityQueue.add(1);

        aPriorityQueue.add(-7);

        //[-7, 1, 2, 4, 5].
        System.out.println(aPriorityQueue.peek()); // -7
        aPriorityQueue.remove();
        //[1, 2, 4, 5].
        System.out.println(aPriorityQueue.peek()); // 1

//        add(item)
//        remove() - - return null if the ADT is empty
//        peek () - return null if the ADT is empty
//        contains(item)
        System.out.println(aPriorityQueue.contains(5));
//        isEmpty()
//        size()

    }
}
