import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingLinkedList {

    Node front;
    Node back;

    void insert( int a ){
        Node new_node = new Node();
        new_node.data = a;

        if(front == null && back == null ){ // Q is empty
            front = new_node;
            back = new_node;
        }else{
            // Q is not empty
            back.next = new_node;
            back = new_node;
        }

    }

    void remove(){
        front = front.next;

    }
    int getSize(){
        int size = 0;
        Node tmpNode = front;
        while(tmpNode != null){
            size++;
            tmpNode = tmpNode.next;
        }
        return  size;
    }
    int peek(){
        return front.data;
    }
    public static void main(String[] args) {
//        QueueUsingLinkedList obj = new QueueUsingLinkedList();
        Queue<Integer> obj = new LinkedList<>();

        obj.add(6);
        obj.add(4);
        obj.add(7);
        obj.add(3);
        obj.remove();
        System.out.println(obj.peek()); // 4
    }
}
