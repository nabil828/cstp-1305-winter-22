import java.util.Iterator;

public class SetUsingLinkedList<T> implements SetInterface<T>{
//    int size = 0;
    NodeGeneric<T> head;
    public void clear(){
        head = null;
    }
    public void add(T a) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException{
        NodeGeneric<T> newNode = new NodeGeneric<T>();
        newNode.data = a;
        if(!contains(a)){
            if(getSize() == 1000)
                throw new AddingIntoFullADTCheckedException();
            newNode.next = head;
            head = newNode;
//            size++;
        }
    }

    public boolean contains(T a) throws AccessingAnEmptyADTCheckedException{
//        if(size == 0)
//            throw new AccessingAnEmptyADTCheckedException();
        NodeGeneric<T> i = head;
        while(i != null){
            if(i.data == a)
                return true;
            i = i.next;
        }
        return false;
    }

    public void remove(T a) throws  AccessingAnEmptyADTCheckedException{
        if(getSize() == 0)
            throw new AccessingAnEmptyADTCheckedException();

        if(contains(a)){
            NodeGeneric<T> tmp = new NodeGeneric<>();
            tmp.next = head;

            NodeGeneric<T> i = tmp;

            // allocate
            NodeGeneric<T> prev = i;
            while(i != null){
                if(a == i.data)
                    break;
                prev = i;
                i = i.next;
            }

            // remove
            if(prev.next == head)
                head = i.next;
            else
                prev.next = i.next;

//            size--;
        }
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    @Override
    public Iterator<T> get_iterator() {
        return null;
    }

    @Override
    public void union(SetInterface<T> a) throws AccessingAnEmptyADTCheckedException, AddingIntoFullADTCheckedException {

    }

    @Override
    public void difference(SetInterface<T> a) throws AccessingAnEmptyADTCheckedException {

    }

    @Override
    public void intersection(SetInterface<T> a) throws AccessingAnEmptyADTCheckedException {

    }

    public int getSize(){
        int size_ = 0;
        NodeGeneric<T> tmp = head;
        while(tmp != null){
            size_++;
            tmp = tmp.next;
        }
        return size_;
    }

    public T[] toArray() throws AccessingAnEmptyADTCheckedException{
        if(getSize() == 0)
            throw new AccessingAnEmptyADTCheckedException();

        T []result_array = (T[])new Object[getSize()];
        NodeGeneric<T> i = head;
        int counter =0;
        while(i != null) {
            result_array[counter++] = i.data;
            i = i.next;
        }

        return  result_array;
    }

    public static <T> SetUsingLinkedList union(SetUsingLinkedList<T> aSet, SetUsingLinkedList<T> anotherSet) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException {
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

    public static <T> SetUsingLinkedList difference(SetUsingLinkedList<T> aSet, SetUsingLinkedList<T> anotherSet) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException {
        SetUsingLinkedList<T> result = new SetUsingLinkedList<T>();
        T [] aSet_array = aSet.toArray();
        for (int i = 0; i < aSet_array.length; i++){
            if(!anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);

        }
        return result;
    }

    public static <T> SetUsingLinkedList intersection(SetUsingLinkedList<T> aSet, SetUsingLinkedList<T> anotherSet) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException {
        SetUsingLinkedList<T> result = new SetUsingLinkedList<T>();
        T [] aSet_array = aSet.toArray();
        for(int i = 0 ;  i < aSet_array.length ; i++){
            if(anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        try{

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
            aSet.add(1);
            SetUsingLinkedList anotherSet = new SetUsingLinkedList();
            anotherSet.add(1);
            anotherSet.add(44);

//            aSet.union(anotherSet);
//            System.out.println(aSet.getSize());
//            System.out.println();

            aSet.difference(anotherSet);
            System.out.println();

            // Union/addAll, Intersection/retainAll, and Difference/removeAll
//            SetUsingLinkedList anotherSet = new SetUsingLinkedList();
//            anotherSet.add(1);
//            anotherSet.add(44);
//
//            SetUsingLinkedList newSet = union(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80, 1, 44
//            newSet = difference(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80
//            aSet.add(44);
//            newSet = difference(anotherSet, aSet); // aSet should have  // 44
//
//
//            anotherSet.add(80);
//            newSet  = intersection(aSet, anotherSet); // aSet should have 80 and 44

            // to raise the AddingIntoFullADTCheckedException
//            int counter = 1;
//            while(true){
//
//                aSet.add(counter);
//                System.out.println(counter++);
//            }

            // to raise the AccessingAnEmptyADTCheckedException
//            SetUsingLinkedList<Integer> aNewSet = new SetUsingLinkedList<Integer>();
//            aNewSet.contains(0);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
