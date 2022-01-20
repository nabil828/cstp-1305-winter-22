// this class is an implementation of the stack ADT
// A stack should implement at least the first two of these operations
// Array is the CDT
public class StackUsingArray {
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

    public static void main(String[] args){
        System.out.println("Hello, this is my first Java code!");


        StackUsingArray object_stack = new StackUsingArray ();
        object_stack.push(6);
        object_stack.push(1);
        object_stack.push(7);
        object_stack.push(8);
        object_stack.pop();
        System.out.println(object_stack.peek()); // we are expecting the 7 to be printed

        int x = 5; // primitive data type integer/ x is a variable
        Integer y = 5; // y is an object!
        String z = y.toString();

    }




}
