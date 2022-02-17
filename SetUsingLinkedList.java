public class SetUsingLinkedList <T> implements SetInterface<T>{
    int size = 0;
    NodeGeneric<T> head;

    public void add(T a){
        NodeGeneric<T> newNode = new NodeGeneric<T>();
        newNode.data = a;
        if(!contains(a)){
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public boolean contains(T a){
        NodeGeneric<T> i = head;
        while(i != null){
            if(i.data == a)
                return true;
            i = i.next;
        }
        return false;
    }

    public void remove(T a){
        if(contains(a)){
            NodeGeneric<T> i = head;

            // allocate
            NodeGeneric<T> prev = i;
            while(i != null){
                if(a == i.data)
                    break;
                prev = i;
                i = i.next;
            }

            // remove
            prev.next = i.next;

            size--;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public T[] toArray(){
        T []result_array = (T[])new Object[size];
        NodeGeneric<T> i = head;
        int counter =0;
        while(i != null) {
            result_array[counter++] = i.data;
            i = i.next;
        }

        return  result_array;
    }

    public static <T> SetUsingLinkedList union(SetUsingLinkedList<T> aSet, SetUsingLinkedList<T> anotherSet){
        SetUsingLinkedList<T> result = new SetUsingLinkedList<T>();
        T [] anotherSet_array = anotherSet.toArray();
        for(int i = 0 ; i < anotherSet_array.length; i++){
            result.add(anotherSet_array[i]);
        }

        T [] aSet_array = aSet.toArray();
        for (int i = 0; i < aSet_array.length; i++){
            result.add(aSet_array[i]);
        }
        return result;
    }

    public static <T> SetUsingLinkedList difference(SetUsingLinkedList<T> aSet, SetUsingLinkedList<T> anotherSet){
        SetUsingLinkedList<T> result = new SetUsingLinkedList<T>();
        T [] aSet_array = aSet.toArray();
        for (int i = 0; i < aSet_array.length; i++){
            if(!anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);

        }
        return result;
    }

    public static <T> SetUsingLinkedList intersection(SetUsingLinkedList<T> aSet, SetUsingLinkedList <T> anotherSet){
        SetUsingLinkedList<T> result = new SetUsingLinkedList<T>();
        T [] aSet_array = aSet.toArray();
        for(int i = 0 ;  i < aSet_array.length ; i++){
            if(anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        SetUsingLinkedList<Integer> aSet = new SetUsingLinkedList<Integer>();
        aSet.add(3);
        aSet.add(1);
        aSet.add(2);
        aSet.add(1); // no effect


        System.out.println(aSet.contains(1)); // true
        System.out.println(aSet.isEmpty()); // false
        System.out.println(aSet.getSize()); // 3

        aSet.remove(1);
        System.out.println(aSet.getSize()); // 2
        aSet.add(5);
        aSet.add(9);
        aSet.add(80);

        // 3, 2, 50, 9, 80


        // Union/addAll, Intersection/retainAll, and Difference/removeAll
        SetUsingLinkedList anotherSet = new SetUsingLinkedList();
        anotherSet.add(1);
        anotherSet.add(44);

        SetUsingLinkedList newSet = union(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80, 1, 44
        newSet = difference(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80
        aSet.add(44);
        newSet = difference(anotherSet, aSet); // aSet should have  // 44


        anotherSet.add(80);
        newSet  = intersection(aSet, anotherSet); // aSet should have 80 and 44

    }
}
