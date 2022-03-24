import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetUsingArraysSeparateClassIteratorTest {

    SetUsingArrays<Integer> aSet = new SetUsingArrays<>();

    SetUsingArraysSeparateClassIterator<Integer> iteratorSet = new
            SetUsingArraysSeparateClassIterator<Integer>(aSet);

    @Test
    public void union(){
        try {
            aSet.clear();
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


            iteratorSet.union(anotherSet);

            assertEquals(7, aSet.getSize());


        } catch (AddingIntoFullADTCheckedException e) {
            e.printStackTrace();
        } catch (AccessingAnEmptyADTCheckedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void intersection() {
        try {
            aSet.clear();
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

            iteratorSet.intersection(anotherSet);

            assertEquals(1, aSet.getSize());
        } catch (AddingIntoFullADTCheckedException e) {
            e.printStackTrace();
        } catch (AccessingAnEmptyADTCheckedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void difference() {
        try {
            aSet.clear();
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

            iteratorSet.difference(anotherSet);

            assertEquals(5, aSet.getSize());


        } catch (AddingIntoFullADTCheckedException e) {
            e.printStackTrace();
        } catch (AccessingAnEmptyADTCheckedException e) {
            e.printStackTrace();
        }
    }
}