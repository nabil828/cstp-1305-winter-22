public interface SetInterface<T> {
    void add(T a ) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException;
    void remove(T a)  throws AccessingAnEmptyADTCheckedException;
    boolean contains(T a)  throws AccessingAnEmptyADTCheckedException;

    int getSize();
    boolean isEmpty();
    <T> T[] toArray()  throws AccessingAnEmptyADTCheckedException;
}
