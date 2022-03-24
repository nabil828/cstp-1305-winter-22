import java.util.Iterator;

public interface SetInterface<T> {
    void clear();
    void add(T a ) throws AddingIntoFullADTCheckedException, AccessingAnEmptyADTCheckedException;
    void remove(T a)  throws AccessingAnEmptyADTCheckedException;
    boolean contains(T a)  throws AccessingAnEmptyADTCheckedException;

    int getSize();
    boolean isEmpty();
    <T> T[] toArray()  throws AccessingAnEmptyADTCheckedException;

    Iterator<T> get_iterator();
    void union (SetInterface<T> a) throws AccessingAnEmptyADTCheckedException, AddingIntoFullADTCheckedException;
    void difference (SetInterface<T> a) throws AccessingAnEmptyADTCheckedException;
    void intersection  (SetInterface<T> a) throws AccessingAnEmptyADTCheckedException;
}
