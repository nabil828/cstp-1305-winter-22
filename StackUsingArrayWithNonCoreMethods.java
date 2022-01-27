// this class is an implementation of the stack ADT
// A stack should implement at least the first two of these operations
// Array is the CDT
public class StackUsingArrayWithNonCoreMethods {
    // I am gonna an array as CDT
    Integer [] arr = new Integer[100]; // in C++  - int arr[100];

    int top = -1;

    // push – insert an item at the top of the stack
    void push(int a){
        top ++;
        arr[top] = a;
    }

    // pop – remove and return the top item
    int pop(){
        int temp = arr[top];
        top--;
        return temp;
    }

    // peek – return the top item
    int peek(){
       return arr[top];
    }

    boolean contains(int a){
        for (int i = 0 ; i< arr.length ; i++ ){
            if(a == arr[i])
                return true;
        }
        return false;
    }

    boolean isEmpty(){
        return top == -1;
    }
    int getFrequencyOf(int a){
        int frequency = 0;
        for (int i = 0 ; i< top + 1 ; i++ ){
            if(a == arr[i])
                frequency++;
        }
        return  frequency;
    }

    void clear(){
        top = -1;
    }
    int size(){
        return top + 1;
    }

    public static void main(String[] args){
        System.out.println("Hello, this is my first Java code!");


        StackUsingArrayWithNonCoreMethods object_stack = new StackUsingArrayWithNonCoreMethods();
        object_stack.push(6);
        object_stack.push(1);
        object_stack.push(7);
        object_stack.push(8);
        object_stack.pop();
        System.out.println(object_stack.peek()); // we are expecting the 7 to be printed

        System.out.println(        object_stack.contains(6)); // true
        System.out.println(object_stack.isEmpty()); // false
        object_stack.push(1); // 6, 1, 7, 1
        System.out.println(        object_stack.getFrequencyOf(1)); // 2
        object_stack.clear(); // the stack is clear
        System.out.println(object_stack.size()); // 0





    }




}
