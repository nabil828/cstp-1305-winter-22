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
    }
}
