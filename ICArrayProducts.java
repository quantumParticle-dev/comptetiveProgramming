import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ICArrayProducts {

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length <2){
            throw new IllegalArgumentException("For multiplication/product we need atleast 2 numbers");
        }

        // make an array of the products

        // [1, 7, 3, 4]
        //7*3*4 , 1*3*4 , 1*7*4 , 1*7*3
        //[3,5,9,4]
        // 5*9*4, 3*9*4, 3*5*4, 3*5*9
        //productBefore;
        //productAfter;
        int[] productsOfAllIntsBeforeIndex = new int[intArray.length];
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsBeforeIndex[i] = productSoFar;
            //1, 3, 15, 135
            productSoFar = productSoFar * intArray[i];
            System.out.println(productsOfAllIntsBeforeIndex[i]);

            //3, 15,135

        }
        productSoFar = 1;
        int[] productsOfAllIntsAfterIndex = new int[intArray.length];
        //[3,5,9,4]
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsAfterIndex[i] = productSoFar;
            //1 , 4, 36, 180 >> 180, 36, 4, 1 (as indexes are length -1.. reversed)
            productSoFar = productSoFar * intArray[i];
            //4, 36,180
            System.out.println(productsOfAllIntsAfterIndex[i]);
        }
//Output multiply 180, 108, 60, 135
        int[] finalArray = new int[intArray.length];
        for (int i =0; i<intArray.length;i++){
            finalArray[i] = productsOfAllIntsBeforeIndex[i] * productsOfAllIntsAfterIndex[i];
        }


        return finalArray;
    }


        // tests

    @Test
    public void smallArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {1, 2, 3});
        final int[] expected = new int[] {6, 3, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {8, 2, 4, 3, 1, 5});
        final int[] expected = new int[] {120, 480, 240, 320, 960, 192};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasOneZeroTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {6, 2, 0, 3});
        final int[] expected = new int[] {0, 0, 36, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoZerosTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {4, 0, 9, 1, 0});
        final int[] expected = new int[] {0, 0, 0, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneNegativeNumberTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-3, 8, 4});
        final int[] expected = new int[] {32, -12, -24};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void allNegativeNumbersTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-7, -1, -4, -2});
        final int[] expected = new int[] {-8, -56, -14, -28};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ICArrayProducts.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
