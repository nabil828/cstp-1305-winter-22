import java.util.Iterator;

public class SetUsingArraysSeparateClassIterator<T> {

    int nextPosition = 0;
    boolean wasNextCalled = false;

    SetUsingArrays<T> aSet;

    SetUsingArraysSeparateClassIterator(SetUsingArrays<T> a){
        aSet = a;
    }

    public boolean hasNext(){
        if(nextPosition  <= aSet.getSize() - 1)
            return true;
        else
            return false;
    }


    T getNextElement(){
        T tmp = aSet.arr[nextPosition];
        nextPosition = nextPosition + 1;
        return tmp;
    }

    T getPrevElement(){
        nextPosition = nextPosition -1;
        T tmp = aSet.arr[nextPosition];


        return tmp;

    }

    public T next(){
        if(hasNext()){
            T iteratorCurrentElement = getNextElement();


            wasNextCalled = true;
            return iteratorCurrentElement;
        }
        else
            throw new RuntimeException("No more!");

    }


    public void remove(){
        if(wasNextCalled){
            wasNextCalled = false;

            T prevElement= getPrevElement();

            try {
                this.aSet.remove(prevElement);
            } catch (AccessingAnEmptyADTCheckedException e) {
                e.printStackTrace();
            }

        }else
            throw new RuntimeException("Next() should be called first");
    }



    public void union (SetUsingArrays<T> a) throws AccessingAnEmptyADTCheckedException, AddingIntoFullADTCheckedException {
//        Iterator it = a.get_iterator();
        SetUsingArraysSeparateClassIterator<T> aIterator = new SetUsingArraysSeparateClassIterator<T>(a);
        while(aIterator.hasNext()){
            T x = (T) aIterator.next();
            if(!this.aSet.contains(x))
                this.aSet.add(x);
        }
    }
    public void difference (SetUsingArrays<T> a) throws AccessingAnEmptyADTCheckedException {
//        Iterator it = a.get_iterator();
        SetUsingArraysSeparateClassIterator<T> aIterator = new SetUsingArraysSeparateClassIterator<T>(a);
        while(aIterator.hasNext()){
            T x = (T) aIterator.next();
            if(this.aSet.contains(x))
                this.aSet.remove(x);
        }
    }
    public void intersection (SetUsingArrays<T> a) throws AccessingAnEmptyADTCheckedException {
//        Iterator it = this.aSet.get_iterator();
        SetUsingArraysSeparateClassIterator<T> aIterator = new SetUsingArraysSeparateClassIterator<T>(a);

        while(hasNext()){
            T x = (T) next();
            if(!aIterator.aSet.contains(x))
                remove();
        }
    }

    public static void main(String[] args) {
        SetUsingArrays<Integer> aSet = new SetUsingArrays<Integer>();
        SetUsingArraysSeparateClassIterator iteratorObject = new SetUsingArraysSeparateClassIterator(aSet);

        try{
//            SetInterface<Integer> aSet = new SetUsingArraysWithInnerIterator<Integer>();
            aSet.add(3);
            aSet.add(1);
            aSet.add(2);
            aSet.add(1); // no effect


            System.out.println(aSet.contains(1)); // true
            System.out.println(aSet.isEmpty()); // false
            System.out.println(aSet.getSize()); // 3

            aSet.remove(1);
            System.out.println(aSet.getSize()); // 2
            aSet.add(5);
            aSet.add(9);
            aSet.add(80);

            // 3, 2, 50, 9, 80
            aSet.add(1);
            SetUsingArrays<Integer> anotherSet = new SetUsingArrays<Integer>();
            anotherSet.add(1);
            anotherSet.add(44);

            iteratorObject.intersection(anotherSet);
            System.out.println();
//            SetUsingArrays newSet = union(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80, 1, 44
//            newSet = difference(aSet, anotherSet); // aSet should have  // 3, 2, 50, 9, 80
//            aSet.add(44);
//            newSet = difference(anotherSet, aSet); // aSet should have  // 44
//
//
//            anotherSet.add(80);
//            newSet  = intersection(aSet, anotherSet); // aSet should have 80 and 44
//
//            // to raise the AddingIntoFullADTCheckedException
//            int counter = 1;
//            while(true){
//                aSet.add(counter);
//                System.out.println(counter++);
//            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
//            System.out.println();
        }

    }

}
