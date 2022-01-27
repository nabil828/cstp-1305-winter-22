import java.lang.reflect.Array;

public class StackUsingArrayWithExceptions<T> implements StackWithExceptionsInterface<T> {
    // I am gonna an array as CDT
    T [] arr ; // in C++  - int arr[100];
    public StackUsingArrayWithExceptions(){
        arr = (T[]) new Object[100];
//        arr =  Array.newInstance(arr, 100);
    }
    int top = -1;
    int size = 0;

    // push – insert an item at the top of the stack

    public void push(T a) throws PushingIntoFullStackCheckedException{

        if(size == 5 ){
            throw new PushingIntoFullStackCheckedException("the Limit of the stack has been reached!");
        }
        top ++;
        arr[top] = a;
        size ++;


    }

    // pop – remove and return the top item
    public T pop() throws AccessingAnEmptyStackCheckedException{
        if(size == 0)
            throw new AccessingAnEmptyStackCheckedException();
        T temp = arr[top];
        top--;
        size--;
        return temp;
    }

    // peek – return the top item
    public T peek(){
        return arr[top];
    }

    public static void main(String[] args){
        System.out.println("Hello, this is my first Java code!");

        try{


        StackUsingArrayWithExceptions object_stack = new StackUsingArrayWithExceptions ();
            object_stack.pop();
        object_stack.push(6);
        object_stack.push(1);
        object_stack.push(7);
        object_stack.push(8);

        object_stack.push(9);

        object_stack.push(10);
        object_stack.pop();
        System.out.println(object_stack.peek()); // we are expecting the 7 to be printed



        }catch(PushingIntoFullStackCheckedException e){
            System.out.println(e.getMessage());
        }catch (AccessingAnEmptyStackCheckedException obj){
            System.out.println(obj.getMessage());

        }
    }



}
