public interface SetInterface<T> {
    void add(T a );
    void remove(T a);
    boolean contains(T a);

    int getSize();
    boolean isEmpty();
    <T> T[] toArray();
}
