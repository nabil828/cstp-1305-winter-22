public class Recursion {

    static void countDown_iterative(int n){
        while(n > 0){
            System.out.println(n);
            n--;
        }
    }
    static void countUp_iterative(int n){
        int i = 1;
        while( i  <= n){
            System.out.println(i);
            i++;
        }
    }

    static void countDown_recursive(int n){
        System.out.println(n);

        if(n > 1){
            countDown_recursive(n-1);
        }
    }

    static void countUp_recursive(int n){
        if(n >= 1){
            countUp_recursive(n-1);
            System.out.println(n);
        }
    }

    public static int sumOf_iterative(int n){
        int sum = 0;
        for (int i = 1 ; i <= n ; i++ ){
            sum += i;
        }
        return  sum;
    }

    public static int sumOf_recursive(int n){
        if( n == 1){
            return  1;
        }else{
            return  n + sumOf_recursive(n-1);
        }

    }
    public static void main(String[] args) {
//        countDown_recursive(10); // 10, 9, 8, ... 1
//        countUp_recursive(10); // 1, 2, 3, ... 10
//        countUp_iterative(10); // 1, 2, 3, ... 10
//        System.out.println(sumOf_iterative(5)); // 1 + 2 + 3 + 4 + 5 = 1
        System.out.println(sumOf_recursive(5)); // 1 + 2 + 3 + 4 + 5 = 15
    }
}
