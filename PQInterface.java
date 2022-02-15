//PQ add elements in an ordered fashion [smallest to largest]. For example, adding 5, 4, 2, 1, -7 to the ADT will result the following stored order in an array:
//        [-7, 1, 2, 4, 5].
//        Peeking and removing will be of element -7 since it is the  smallest element in the collection.
//        Adding 3 to the ADT will result
//        [-7, 1, 2, 3, 4, 5].
//
//        - Create an interface for the ADT and classes for the CDTs.
//
//        PQ supports the following operations
//        add(item)
//        remove() - - return null if the ADT is empty
//        peek () - return null if the ADT is empty
//        contains(item)
//        isEmpty()
//        size()

public interface PQInterface {
    //return null if the ADT is empty
    public Integer remove();
    //return null if the ADT is empty
    public Integer peek();

    //
    public void add (int a);

    public boolean contains(int a);

}
