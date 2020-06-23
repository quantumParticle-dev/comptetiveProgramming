import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ICHigestProductof3IntArray {

    public static int highestProductOf3(int[] intArray) {





        // calculate the highest product of three numbers

        //-5, 4, 8, 2, 3
        //-10, 1, 3, 2, -1
        //1, 2, 3, 4
        //-10,-1,1,2,3
        //-5,2,3,4,8

        //2 negatives

        //non negative- simple sort the array and take last 3 indeces product.
        // 1 negative- ignore that negative, simple sort the array and take last 3 indeces product.
        //all negatives- sort array, take product of last 3 indeces.

        // 2 negatives
        //-10, 1, 3, 2, 9, -1

        //-10,-1,1,2,3,9 >> 54,90


        //1,2,3,9,10
        //-1, 1, 3, 2, 9, -1
        //-1,-1,1,2,3,9
        //1,1,2,3,9

        //-10,-7,1,2,3,9 >> -10,-7,1,2,3,9 >> 54, 630
        //-10,-7,18,20,3,9 >> -10,-7,3,9,18,20 >> 3240,1400
        //1,2,3,9,70
        //-2,-1,1,2,3,9
        //1,2,2,3,9
        //3 negatives
        //-10, 1, 3, 2, -1, -4
        if (intArray.length <3){
            throw new IllegalArgumentException("Atleast 3 elements are needed for a product of three");
        }

        Arrays.sort(intArray);
        int len = intArray.length;
        int product = Math.max((intArray[len -1]*intArray[len -2]*intArray[len -3]),(intArray[0]*intArray[1]*intArray[len-1]));

        return product;
    }


















    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ICHigestProductof3IntArray.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}