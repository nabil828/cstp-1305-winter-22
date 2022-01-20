
// this stack has a limit of 5 items at max
// it should raise an exception whenever this limit=5 is reached
// it would also raise an exception whenever we peek or pop from an empty stack
public interface StackWithExceptionsInterface<T> {
    // push – insert an item at the top of the stack
    // @throws PushingIntoFullStackCheckedException exceptoion whenever it is fullge
    public void push (T a) throws PushingIntoFullStackCheckedException;

    public T pop() throws AccessingAnEmptyStackCheckedException;
    public T peek();
}
