public class Algorithms {

    static void swap(int[] arr, int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

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

    static void bubble_sort(int []arr){
        for(int i = arr.length - 1 ; i > 0 ; i-- ){
            for(int j = 0 ; j < i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j +1);
            }
        }
    }

    static void selection_sort(int [] arr){
        for(int i = 0; i < arr.length ; i++){

            // find the smallest element
            int min = 999999;
            int smallest_index = -1;
            for(int j = i ; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    smallest_index = j;
                }
            }

            swap(arr, i, smallest_index);
        }
    }

    static void insertion_sort(int [] arr){
        for(int i = 1 ; i < arr.length ; i++){

            int j = i;
            int tmp = arr[j];
            while (j  > 0 && arr[j - 1] > tmp ){
                // shift
                arr[j] = arr[j -1];
                j--;
            }
            // place
            arr[j] = tmp;

        }
//        int n = arr.length;
//        for (int i = 1; i < n; ++i) {
//            int key = arr[i];
//            int j = i - 1;
//
//            /* Move elements of arr[0..i-1], that are
//               greater than key, to one position ahead
//               of their current position */
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            arr[j + 1] = key;
//        }
    }
    public static void main(String[] args) {
        int []arr = new int [10];
//        arr = new int[]{10, 20, 30, 15, 25, 3};

//        int target = 3;
//        System.out.println(linear_search(arr, target)); // index 5
//        System.out.println(linear_search(arr, 44)); // index 5


//        arr = new int[]{10, 12, 30, 41, 59, 60};
//
//         int target = 12;
//        System.out.println(binary_search(arr, target));// 1 - index

//        arr = new int[]{ 12,  59, 6, 30, 15, 41};
//        bubble_sort(arr); //

        arr = new int[]{ 12,  59, 6, 30, 15, 41};
//        selection_sort(arr); //
        insertion_sort(arr);
        for(int x : arr){
            System.out.println(x);
        }
        // 6 , 12, 15, 30, 41, 59


    }
}
