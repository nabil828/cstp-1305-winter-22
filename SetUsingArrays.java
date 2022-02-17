public class SetUsingArrays<T> implements SetInterface<T>{
    T[]arr = (T[]) new Object[1];
    int size = 0;

    void resize(){
        T arr_new [] = (T[])new Object[arr.length  * 2];
        for ( int i = 0 ; i< arr.length;i++){
            arr_new[i] =arr[i];
        }
        arr = arr_new;
    }

    public void add(T a) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException{
        if(!contains(a)){
            if(size == 1000)
                throw new AddingIntoFullADTCheckedException("");
            if(size >= .8 * arr.length)
                resize();
            arr[size++] = a;
        }
    }

    public boolean contains(T a) throws AccessingAnEmptyADTCheckedException{

        if(size == 0)
            throw new AccessingAnEmptyADTCheckedException();
        for(int i = 0; i < size; i++)
            if(arr[i] == a)
                return true;
        return false;
    }

    public void remove (T a)throws AccessingAnEmptyADTCheckedException
    {
        if(size == 0)
            throw new AccessingAnEmptyADTCheckedException();
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

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public <T> T[] toArray() throws AccessingAnEmptyADTCheckedException{
        if(size == 0)
            throw new AccessingAnEmptyADTCheckedException();
        T []result_array = (T[]) new Object[size];
        for(int i = 0 ; i <result_array.length; i++ )
            result_array[i] = (T) arr[i];
        return  result_array;
    }

    public static <T>SetUsingArrays union(SetUsingArrays<T> aSet, SetUsingArrays<T> anotherSet) throws AddingIntoFullADTCheckedException , AccessingAnEmptyADTCheckedException{
        SetUsingArrays<T> result = new SetUsingArrays<T>();
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

    public static <T>SetUsingArrays difference(SetUsingArrays<T> aSet, SetUsingArrays<T> anotherSet) throws AddingIntoFullADTCheckedException , AccessingAnEmptyADTCheckedException{
        SetUsingArrays<T> result = new SetUsingArrays<T>();
        T [] aSet_array = aSet.toArray();
        for (int i = 0; i < aSet_array.length; i++){
            if(!anotherSet.contains(aSet_array[i]))
                result.add(aSet_array[i]);

        }
        return result;
    }

    public static <T> SetUsingArrays intersection(SetUsingArrays<T> aSet, SetUsingArrays<T> anotherSet) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException {
        SetUsingArrays<T> result = new SetUsingArrays<T>();

        T [] aSet_array = aSet.toArray();
        for(int i = 0 ;  i < aSet_array.length ; i++){
                if(anotherSet.contains(aSet_array[i]))
                    result.add(aSet_array[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        try{

            SetUsingArrays<Integer> aSet = new SetUsingArrays<Integer>();
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

            // to raise the AddingIntoFullADTCheckedException
            int counter = 1;
            while(true){
                aSet.add(counter);
                System.out.println(counter++);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
//            System.out.println();
        }

    }
}
