import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ICArrayThreeIntegerProduct {

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

        //https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
        //https://www.geeksforgeeks.org/maximum-product-quadruple-sub-sequence-size-4-array/?ref=rp

        if (intArray.length <4){
            throw new IllegalArgumentException("Atleast 3 elements are needed for a product of three");
        }

        Arrays.sort(intArray);
        int len = intArray.length;
        //Max of product of (last 3 elements of array or first 2 elements *last) on sorted array will always give max product of 3.
        int product = Math.max((intArray[len -1]*intArray[len -2]*intArray[len -3]),(intArray[0]*intArray[1]*intArray[len-1]));

        //MaxProduct for  4 integers in array. It works for all but fails if all negatives in array. Mat.max((first *second* last *secondlast), last 4)
        //int product = Math.max((intArray[len -1]*intArray[len -2]*intArray[len -3]*intArray[len-4]),(intArray[0]*intArray[1]*intArray[len-1]*intArray[len -2]));

        return product;
    }


















    // tests
//test for max product of 4 arrays. The approach fails if all negative in array.
//    @Test
//    public void short4ArrayTest() {
//        final int actual = highestProductOf3(new int[] {1, 2, 3, 4, 5, 6});
//        final int expected = 360;
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void short4ArrayTestNeg() {
//        final int actual = highestProductOf3(new int[] {-15, 4, 8, 2, 3, 11, -3});
//        //>> -15,-3,2,3,4,8,11 >> 1056,3960
//        final int expected = 3960;
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void short4ArrayTestAllNeg() {
//        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2, -11, -7});
//        // -11,-7,-5,-3,-2,-1 >> 154,
//        final int expected = 1155;
//        assertEquals(expected, actual);
//    }

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
        //-5,-3,-2,-1 >> -15,-6
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
        Result result = JUnitCore.runClasses(ICArrayThreeIntegerProduct.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}