public class QueueUsingResizableArray {
    int arr [] = new int[1];
    int num; // the actual size of the queue
    int front;
    QueueUsingResizableArray(){
        num = 0;
        front =0;
    }
    void resize(){
        int arr_new [] = new int[arr.length  * 2];
        for ( int i = 0 ; i< arr.length;i++){
            arr_new[i] =arr[i];
        }
        arr = arr_new;
    }
    void insert(int a){
        if(num == arr.length)
            resize();
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
        QueueUsingResizableArray obj = new QueueUsingResizableArray();
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
