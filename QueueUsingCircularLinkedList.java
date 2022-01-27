import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingCircularLinkedList {
    Node front;
    Node back;

    QueueUsingCircularLinkedList(){
        front = null;
        back = null;
    }

    void add(int a){

        // 1
        Node new_node = new Node();
        new_node.data = a;

        if (front == null){ // empty Q
            front = new_node;
            back = new_node;
        }
        else{ //there is at least one node in the queue
            // 2
            back.next = new_node;

            // 3
            new_node.next = front;

            // 4
            back = new_node;
        }
    }
    void remove(){
        if(front != null){ // at least we have one to remove
            front = front.next;
            back.next = front;
        }
        // otherwise, throw an exception
    }
    int peek(){
        if(front != null){ // at least we have one to remove
             return front.data;
        }
        else{
            return -1; //
            // otherwise, throw an exception
        }
    }


    public static void main(String[] args) {
        QueueUsingCircularLinkedList obj = new QueueUsingCircularLinkedList();

        obj.add(6);
        obj.add(4);
        obj.add(7);
        obj.add(3);
        obj.remove();
        System.out.println(obj.peek()); // 4
    }
}
