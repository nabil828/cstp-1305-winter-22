public class QueueSeparateClassIterator {

    int nextPosition = 0;
    boolean wasNextCalled = false;

    QueueUsingLinkedList aQueue = new QueueUsingLinkedList();

    QueueSeparateClassIterator(QueueUsingLinkedList a){
        aQueue = a;
    }

    boolean hasNext(){
        if(nextPosition < aQueue.get_size())
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

    void remove(){
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
        QueueSeparateClassIterator iteratorObject = new QueueSeparateClassIterator(aQueue);
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
