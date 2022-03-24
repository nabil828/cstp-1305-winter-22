public class PQUsingLinkedList implements PQInterface{
    Node head;
    PQUsingLinkedList(){
        head = null;
        size =0 ;
    }
    int size;
    public void add(int a){

        // 0- create node
        Node aNewNode = new Node();
        aNewNode.data = a;

        if(size == 0){
            head = aNewNode;
        }else {


            // Current:     1 => 2 => 5 => null
            // Goal:        1 => 2 => 4 =>  5 => null

            // 1 - find the position
            Node i = head;
            Node prev = i;
            while (i != null && a > i.data ) {
                prev = i;
                i = i.next;
            }

            // 2- insert
            if(i == prev){
                aNewNode.next = head;
                head  = aNewNode;
            }else{
                prev.next = aNewNode;
                aNewNode.next = i;
            }

        }
        size++;
    }

    public Integer peek(){
        if(size == 0)
            return  null;
        return head.data;
    }
    public Integer remove(){
        if(size == 0)
            return  null;
        // 1 => 2 => 4 =>  5 => null
        // 2 => 4 =>  5 => null
        Integer result = head.data;
       head = head.next;
        return result;
    }

    public boolean contains(int a){
        Node i = head;
        while(i != null){
            if(a == i.data)
                return true;

            i = i.next;
        }
        return false;
    }
    public boolean isEmpty(){
        return  size == 0;
    }
    // driver code
    public static void main(String[] args) {
        PQInterface aPriorityQueue = new PQUsingLinkedList();
        //5, 4, 2, 1, -7
        aPriorityQueue.add(1);
        aPriorityQueue.add(5);
        aPriorityQueue.add(2);
        // [1, 2, 5]
        aPriorityQueue.add(4); // find position - index 2 -   shift and insert
        // [1, 2, 4, 5]


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
