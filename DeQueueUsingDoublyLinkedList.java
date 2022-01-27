public class DeQueueUsingDoublyLinkedList {

    DoublyNode front;
    DoublyNode back;

    void insert_back(int a){
        // 1
        DoublyNode new_node = new DoublyNode();
        new_node.data = a;

        if(front == null ){
            front = new_node;
            back = new_node;
        }else{
            // 2
            new_node.prev = back;

            // 3
            back.next = new_node;

            // you may flip 2 and 3

            back = new_node;
        }
    }


    void insert_front(int a){
        // 1
        DoublyNode new_node = new DoublyNode();
        new_node.data = a;

        if(front == null ){
            front = new_node;
            back = new_node;
        }else{
            // 2
            new_node.next = front;

            // 3
            front.prev = new_node;

            // you may flip 2 and 3
            front = new_node;
        }
    }

    void remove_front(){
        front = front.next;

        // throw an exception if the dQ is empty
    }

    void remove_back(){
        DoublyNode tmp = back;
        back = back.prev;

        back.next = null;
        tmp.prev = null;

        // throw an exception if the dQ is empty
    }

    int peek_front(){
        return front.data;
        // throw an exception if the dQ is empty
    }


    int peek_back(){
        return back.data;
        // throw an exception if the dQ is empty
    }
    public static void main(String[] args) {

        DeQueueUsingDoublyLinkedList q = new DeQueueUsingDoublyLinkedList();
        q.insert_back(10);
        q.insert_back(4);
        q.insert_back(2);
        q.insert_back(5);

        System.out.println(q.peek_front()); // 10
        System.out.println(q.peek_back()); // 5

        q.remove_back();
        System.out.println(q.peek_back()); // 2


    }
}
