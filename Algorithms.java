public class Algorithms {
    static int linear_search(int arr[], int target){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target)
                return i;

        }

        return  -1;

    }
    public static void main(String[] args) {
        int []arr = new int [10];
        arr = new int[]{10, 20, 30, 15, 25, 3};

        int target = 3;
        System.out.println(linear_search(arr, target)); // index 5
        System.out.println(linear_search(arr, 44)); // index 5

    }
}
