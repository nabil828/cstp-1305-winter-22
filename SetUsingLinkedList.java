public class SetUsingLinkedList implements SetInterface{
    int size = 0;
    Node head;

    public void add(int a){
        Node newNode = new Node();
        newNode.data = a;
        if(!contains(a)){
            newNode.next = head;
            head = newNode;

            size++;
        }
    }

    public boolean contains(int a){
        Node i = head;
        while(i != null){
            if(i.data == a)
                return true;
            i = i.next;
        }
        return false;
    }

    public void remove(int a){
        if(contains(a)){
            Node i = head;

            // allocate
            Node prev = i;
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

    public int[] toArray(){
        int []result_array = new int[size];
        Node i = head;
        int counter =0;
        while(i != null) {
            result_array[counter++] = i.data;
            i = i.next;
        }

        return  result_array;
    }

    public static SetUsingLinkedList union(SetUsingLinkedList aSet, SetUsingLinkedList anotherSet){
        SetUsingLinkedList result = new SetUsingLinkedList();
        int [] anotherSet_array = anotherSet.toArray();
        for(int i = 0 ; i < anotherSet_array.length; i++){
            result.add(anotherSet_array[i]);
        }

        int [] aSet_array = aSet.toArray();
        for (int i = 0; i < aSet_array.length; i++){
            result.add(aSet_array[i]);
        }
        return result;
    }

    public static SetUsingLinkedList difference(SetUsingLinkedList aSet, SetUsingLinkedList anotherSet){
        SetUsingLinkedList result = new SetUsingLinkedList();
        int [] aSet_array = aSet.toArray();
        for (int i = 0; i < aSet_array.length; i++){
            if(!anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);

        }
        return result;
    }

    public static SetUsingLinkedList intersection(SetUsingLinkedList aSet, SetUsingLinkedList anotherSet){
        SetUsingLinkedList result = new SetUsingLinkedList();
        int [] aSet_array = aSet.toArray();
        for(int i = 0 ;  i < aSet_array.length ; i++){
            if(anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        SetUsingLinkedList aSet = new SetUsingLinkedList();
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
