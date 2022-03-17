import java.util.Iterator;

public class SeparateClassIterator implements Iterator<Integer> {

    // for iterator
    int nextPosition = 0; // first item is item #1
    QueueUsingLinkedList aQueue;


    public SeparateClassIterator(QueueUsingLinkedList a){
        this.aQueue = a;
    }

    public boolean hasNext(){
        if(nextPosition < aQueue.getSize())
            return true;
        else
            return false;
    }

    Node getNextNode(){
        int count = 0;
        Node nextNode = aQueue.front;
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
        Node tmpNode = aQueue.front;
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

    public Integer next(){
        if(hasNext()){
            Node iteratorCurrentNode = getNextNode();
            nextPosition++;


            wasNextCalled = true;
            return iteratorCurrentNode.data;
        }
        else
            throw new RuntimeException("No more!");

    }

    public void remove(){
        if(wasNextCalled){
            wasNextCalled = false;

            Node prevNode = getPrevNode();

            Node tmpNode = aQueue.front;
            Node prevTmp = new Node();
            prevTmp.next = aQueue.front;
            while(tmpNode != prevNode){
                prevTmp = tmpNode;
                tmpNode = tmpNode.next;
            }

            // change the front if the it is one to be removed
            if(prevTmp.next == aQueue.front)
                aQueue.front = prevTmp.next.next;
            else//removal
                prevTmp.next = prevTmp.next.next;

            nextPosition--;

        }else
            throw new RuntimeException("Next() should be called first");

    }

    public static void main(String[] args) {
        QueueUsingLinkedList aQueue = new QueueUsingLinkedList();
        SeparateClassIterator iteratorObject = new SeparateClassIterator(aQueue);
//        Queue<Integer> obj = new LinkedList<>();

        aQueue.insert(6);
        aQueue.insert(4);
        aQueue.insert(17);
        aQueue.insert(3);
//        obj.remove();
        // System.out.println(obj.peek()); // 4

//        while(obj.hasNext()) {
//            System.out.println(obj.next());
//        }

        while(iteratorObject.hasNext()) {
            Integer i = iteratorObject.next();
            if(i < 10) {
                iteratorObject.remove();;
            }
        }
    }
}
