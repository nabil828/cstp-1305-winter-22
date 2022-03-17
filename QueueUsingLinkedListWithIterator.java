public class QueueUsingLinkedListWithIterator {

    Node front;
    Node back;

    // for iterator
    int nextPosition = 0; // first item is item #1
    int size = 0;

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
        size++;
    }

    boolean hasNext(){
        if(nextPosition < size)
            return true;
        else
            return false;
    }

    Node getNextNode(){
        int count = 0;
        Node nextNode = front;
        while (nextNode != null){
            if(count == nextPosition)
                break;
            count++;
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    Node getPrevNode(){
        int count = 0;
        Node tmpNode = front;
        Node prevNode = null;
        while (tmpNode != null){
            if(count == nextPosition)
                break;
            count++;
            prevNode = tmpNode;
            tmpNode = tmpNode.next;
        }
        return prevNode;
    }

    boolean wasNextCalled = false;
    int next(){
        if(hasNext()){
            Node iteratorCurrentNode = getNextNode();
            nextPosition++;


            wasNextCalled = true;
            return iteratorCurrentNode.data;
        }
        else
            throw new RuntimeException("No more!");

    }

    void iteratorRemove(){
    if(wasNextCalled){
        wasNextCalled = false;

        Node prevNode = getPrevNode();

        Node tmpNode = front;
        Node prevTmp = new Node();
        prevTmp.next = front;
        while(tmpNode != prevNode){
            prevTmp = tmpNode;
            tmpNode = tmpNode.next;
        }

        // change the front if the it is one to be removed
        if(prevTmp.next == front)
            front = prevTmp.next.next;
        else//removal
            prevTmp.next = prevTmp.next.next;

        nextPosition--;

    }else
        throw new RuntimeException("Next() should be called first");

    }

    void remove(){
        front = front.next;
        size--;
    }

    int peek(){
        return front.data;
    }
    public static void main(String[] args) {
        QueueUsingLinkedListWithIterator obj = new QueueUsingLinkedListWithIterator();
//        Queue<Integer> obj = new LinkedList<>();

        obj.insert(6);
        obj.insert(4);
        obj.insert(17);
        obj.insert(3);
//        obj.remove();
       // System.out.println(obj.peek()); // 4

//        while(obj.hasNext()) {
//            System.out.println(obj.next());
//        }

        while(obj.hasNext()) {
            Integer i = obj.next();
            if(i < 10) {
                obj.iteratorRemove();;
            }
        }
    }
}
