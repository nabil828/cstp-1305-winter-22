
// This stack will hold up to 5 items only
// todo ..
public class StackUsingLinkedListWithExceptions implements StackWithExceptionsInterface{

    // to use a linked list as data structure/cdt
    Node top;

    StackUsingLinkedListWithExceptions() { // Constructors are used in classes to initialize data members
        top = null;
    }

    int size = 0;

    // todo specifications should be provided
    public void push(int a) throws PushingIntoFullStackCheckedException {
        if (size == 5)
            throw new PushingIntoFullStackCheckedException("PushingIntoFullStackCheckedException");
        Node temp = new Node();
        temp.data = a;
        temp.next = null;

        // check whether the stack is empty or not
        if (top == null) {
            top = temp;
        } else {
            // the stack is not empty
            temp.next = top;
            top = temp;
        }
        size++;
    }

    // todo specifications should be provided
    // return -1 if the stack is empty .. more on this later when we talk about exceptions
    public int pop() throws AccessingAnEmptyStackCheckedException {
        if (size == 0)
            throw new AccessingAnEmptyStackCheckedException("AccessingAnEmptyStackCheckedException");
        int temp = top.data;
        top = top.next;

        size--;
        return temp;
    }

    // todo specifications should be provided
    // return -1 if the stack is empty .. more on this later when we talk about exceptions
    public int peek() {
        if (top == null) {
            //stack is empty
            return -1;
        } else
            return top.data;
    }


    public static void main(String[] args) {
        System.out.println("Hello, this is my first Java code!");

        try {
            StackUsingLinkedListWithExceptions object_stack = new StackUsingLinkedListWithExceptions();
            object_stack.push(6);
            object_stack.push(1);
            object_stack.push(7);
            object_stack.push(8);
            object_stack.pop();
            System.out.println(object_stack.peek()); // we are expecting the 7 to be printed

            String postfix_expr = "512+4*+3-";
            StackWithExceptionsInterface x = new StackUsingLinkedListWithExceptions();
            for (int i = 0; i < postfix_expr.length(); i++) {
                char next = postfix_expr.charAt(i);

                if (next == '+' || next == '-' || next == '/' || next == '*') {
                    int op1 = (x.pop());
                    int op2 = (x.pop());
                    switch (next) {
                        case '+':
                            x.push(op2 + op1);
                            break;
                        case '-':
                            x.push(op2 - op1);
                            break;
                        case '/':
                            x.push(op2 / op1);
                            break;
                        case '*':
                            x.push(op2 * op1);
                            break;
                        default:
                            break;
                    }
                } else {
                    x.push(Integer.parseInt(String.valueOf(next)));
                }
            }
            System.out.println("result: " + x.peek());
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
