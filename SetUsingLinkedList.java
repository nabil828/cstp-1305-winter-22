public class SetUsingLinkedList {
    int size = 0;
    Node head;

    void add(int a){
        Node newNode = new Node();
        newNode.data = a;
        if(!contains(a)){
            newNode.next = head;
            head = newNode;

            size++;
        }
    }

    Boolean contains(int a){
        Node i = head;
        while(i != null){
            if(i.data == a)
                return true;
            i = i.next;
        }
        return false;
    }

    void remove(int a){
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

    boolean isEmpty(){
        return size == 0;
    }

    int getSize(){
        return size;
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
        aSet.add(80); // size 5
        System.out.println(aSet.getSize()); // 5
        aSet.remove(80);
        System.out.println(aSet.getSize()); // 4
        aSet.remove(1);
        System.out.println(aSet.getSize()); // 4

    }
}
