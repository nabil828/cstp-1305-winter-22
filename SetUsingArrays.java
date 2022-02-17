public class SetUsingArrays {
    int []arr = new int[1];
    int size = 0;

    void resize(){
        int arr_new [] = new int[arr.length  * 2];
        for ( int i = 0 ; i< arr.length;i++){
            arr_new[i] =arr[i];
        }
        arr = arr_new;
    }

    void add(int a){
        if(!contains(a)){
            if(size >= .8 * arr.length)
                resize();
            arr[size++] = a;
        }
    }

    boolean contains(int a){
        for(int i = 0; i < size; i++)
            if(arr[i] == a)
                return true;
        return false;
    }

    void remove(int a)
    {
        // find position
        int i;
        for(i = 0; i < size; i++)
            if(arr[i] == a)
                break;
        // shift
        // [1, 2, 3]
        //remove(2)
        // i = 1
        // size = 3
        while(i < size){
            arr[i] = arr[i+1];
            i++;
        }

        size--;
    }

    int getSize(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }


    int[] toArray(){
        int []result_array = new int[size];
        for(int i = 0 ; i <result_array.length; i++ )
            result_array[i] = arr[i];
        return  result_array;
    }

    public static SetUsingArrays union(SetUsingArrays aSet, SetUsingArrays anotherSet){
        SetUsingArrays result = new SetUsingArrays();
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

    public static SetUsingArrays difference(SetUsingArrays aSet, SetUsingArrays anotherSet){
        SetUsingArrays result = new SetUsingArrays();
        int [] aSet_array = aSet.toArray();
        for (int i = 0; i < aSet_array.length; i++){
            if(!anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);

        }
        return result;
    }

    public static SetUsingArrays intersection(SetUsingArrays aSet, SetUsingArrays anotherSet){
        SetUsingArrays result = new SetUsingArrays();
        int [] aSet_array = aSet.toArray();
        for(int i = 0 ;  i < aSet_array.length ; i++){
                if(anotherSet.contains(aSet_array[i]))
                    result.add(aSet_array[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        SetUsingArrays aSet = new SetUsingArrays();
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
        SetUsingArrays anotherSet = new SetUsingArrays();
        anotherSet.add(1);
        anotherSet.add(44);

        SetUsingArrays newSet = union(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80, 1, 44
        newSet = difference(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80
        aSet.add(44);
        newSet = difference(anotherSet, aSet); // aSet should have  // 44


        anotherSet.add(80);
        newSet  = intersection(aSet, anotherSet); // aSet should have 80 and 44

    }
}
