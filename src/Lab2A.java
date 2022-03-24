

public class Lab2A {

    public static void main(String[] args) {


        Node node_5 = new Node();
        node_5.data = 5;


        Node node_2 = new Node();
        node_2.data = 2;

        Node node_1 = new Node();
        node_1.data = 1;

        Node node_10 = new Node();
        node_10.data = 10;

        node_5.next = node_2;
        node_2.next = node_1;
        node_1.next = node_10;
        node_10.next = null;


        // step 2
        // we need to remove node_2

        node_5.next = node_1;

        // step 3
        // we need to insert node_6 inbetween nodes 1 and 10

        Node node_6 = new Node();
        node_6.data = 6;

        node_6.next = node_10;
        node_1.next = node_6;




    }
}
