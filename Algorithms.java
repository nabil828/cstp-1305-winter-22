public class Algorithms {
    static int linear_search(int arr[], int target){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target)
                return i;

        }

        return  -1;

    }

    static int binary_search(int arr[], int target){


        int l = 0;
        int r = arr.length - 1;

        while( l <= r){
            int m = (l + r) / 2;
            if (arr[m] == target)
                return m;
            else{
                if(target < arr[m]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }
        return  -1;

    }
    public static void main(String[] args) {
        int []arr = new int [10];
//        arr = new int[]{10, 20, 30, 15, 25, 3};

//        int target = 3;
//        System.out.println(linear_search(arr, target)); // index 5
//        System.out.println(linear_search(arr, 44)); // index 5


        arr = new int[]{10, 12, 30, 41, 59, 60};

         int target = 12;
        System.out.println(binary_search(arr, target));// 1 - index


    }
}
