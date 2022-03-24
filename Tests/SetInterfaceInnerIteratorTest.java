import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class SetInterfaceInnerIteratorTest {
    SetInterface<Integer> aSet;

    public SetInterfaceInnerIteratorTest(SetInterface<Integer> aSet) {
        this.aSet = aSet;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new SetUsingLinkedListWithInnerIterator<Integer>()},
                {new SetUsingArraysWithInnerIterator<Integer>()}
        });
    }


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
            SetUsingLinkedListWithInnerIterator anotherSet = new SetUsingLinkedListWithInnerIterator();
            anotherSet.add(1);
            anotherSet.add(44);


            aSet.union(anotherSet);

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
            SetUsingLinkedListWithInnerIterator anotherSet = new SetUsingLinkedListWithInnerIterator();
            anotherSet.add(1);
            anotherSet.add(44);


            aSet.intersection(anotherSet);

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
            SetUsingLinkedListWithInnerIterator anotherSet = new SetUsingLinkedListWithInnerIterator();
            anotherSet.add(1);
            anotherSet.add(44);


            aSet.difference(anotherSet);

            assertEquals(5, aSet.getSize());


        } catch (AddingIntoFullADTCheckedException e) {
            e.printStackTrace();
        } catch (AccessingAnEmptyADTCheckedException e) {
            e.printStackTrace();
        }
    }
}
