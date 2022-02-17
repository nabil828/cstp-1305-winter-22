public class SetUsingArrays {
    int []arr = new int[1];
    void add(int a){
        ;
    }
    boolean contains(int a){
        return  false;
    }

    void remove(int a)
    {
        ;
    }
    int getSize(){
        return 0;
    }

    boolean isEmpty(){
        return false;
    }


    public static void main(String[] args) {
        SetUsingArrays aSet = new SetUsingArrays();
        aSet.add(3);
        aSet.add(1);
        aSet.add(2);
        aSet.add(1); // no effect


        aSet.contains(1); // true
        aSet.isEmpty(); // false
        aSet.getSize(); // 3

        aSet.remove(1);
        aSet.getSize(); // 2
    }
}
