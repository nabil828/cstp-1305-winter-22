import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(value = Parameterized.class)
public class
SetInterfaceTest {

    SetInterface<Integer> aSet;

    public SetInterfaceTest(SetInterface<Integer> aSet) {
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
    public void addTest(){
        System.out.println("addTest: " + this.aSet.hashCode());
        try {
            aSet.add(1);
            assertEquals(true, aSet.contains(1));

            aSet.add(2);
            assertEquals(true, aSet.contains(2));


            aSet.remove(2);
            assertEquals(false, aSet.contains(2));
            assertEquals(true, aSet.contains(1));

            aSet.remove(1);
            assertEquals(false, aSet.contains(2));
            assertEquals(false, aSet.contains(1));
            assertEquals(0, aSet.getSize());

        } catch (AddingIntoFullADTCheckedException e) {
            e.printStackTrace();
        } catch (AccessingAnEmptyADTCheckedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = AccessingAnEmptyADTCheckedException.class)
    public void removeTest() throws AccessingAnEmptyADTCheckedException, AddingIntoFullADTCheckedException {
        aSet.clear();
        System.out.println("removeTest: " + this.aSet.hashCode());
        // remove from empty
        aSet.remove(1);

    }

    @Test
    public void removeTest2() throws AccessingAnEmptyADTCheckedException, AddingIntoFullADTCheckedException {
        aSet.clear();
        System.out.println("removeTest2: " + this.aSet.hashCode());
        // remove from end
        aSet.add(1);
        assertEquals(1, aSet.getSize());
        aSet.add(2);
        assertEquals(2, aSet.getSize());
        aSet.remove((2));
        aSet.add(1);
        assertEquals(1, aSet.getSize());

        // remove from middle
        aSet.add(3);
        assertEquals(2, aSet.getSize());
        aSet.add(4);
        assertEquals(3, aSet.getSize());
        aSet.remove(3);
        assertEquals(2, aSet.getSize());
    }

    @Test
    public void containsTest() throws AccessingAnEmptyADTCheckedException, AddingIntoFullADTCheckedException {
        // test empty set
        aSet.clear();
        assertEquals(false, aSet.contains(1));

        // test an added element
        aSet.add(1);
        aSet.contains(1);
        assertEquals(true, aSet.contains(1));
    }






}
