public class QueueUsingArray {
    int arr [] = new int[6];
    int num; // the actual size of the queue
    int front;
    QueueUsingArray(){
        num = 0;
        front =0;
    }
    void insert(int a){
        arr[(front + num ) % arr.length] = a;
        num = num  + 1 ;
    }
    int peek(){
     return arr[front];
    }
    void remove(){
        front = (front + 1) % arr.length;
        num = num -     1;
    }

    public static void main(String[] args) {
        QueueUsingArray obj = new QueueUsingArray();
        obj.insert(6);
        obj.insert(4);
        obj.insert(7);
        obj.insert(3);
        obj.insert(8);
        obj.remove();
        obj.remove();
        obj.insert(9);
        obj.insert(5);

        // 7 should be the front of the queue
        System.out.println(obj.peek());// return 7

    }
}
