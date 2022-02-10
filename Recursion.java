public class Recursion {

    static void countDown_iterative(int n){
        while(n > 0){
            System.out.println(n);
            n--;
        }
    }

    static void countDown_recursive(int n){
        System.out.println(n);

        if(n > 1){
            countDown_recursive(n-1);
        }
    }
    public static void main(String[] args) {
        countDown_recursive(10); // 10, 9, 8, ... 1
    }
}
