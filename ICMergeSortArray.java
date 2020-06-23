import com.sun.tools.javac.util.ArrayUtils;
import org.apache.poi.util.ArrayUtil;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ICMergeSortArray {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        // combine the sorted arrays into one large sorted array
        //  int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        //int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

        //final int[] myArray = {2, 4, 6};
        //final int[] alicesArray = {1, 3, 7};
        //final int[] expected = {1, 2, 3, 4, 6, 7};
        //3
        //3
        //6
        //<3 >> 2,4,6
        // 2,4,6,1,3,7


        int lengthFirst = myArray.length;
        int lengthSecond = alicesArray.length;
        int lengthCombine = lengthFirst + lengthSecond;
        int[] combineArray = new int[lengthCombine];
        //Arrays.copyOfRange(myArray, startIndex, endIndex);

        for (int i =0;i<myArray.length;i++){
            combineArray[i] = myArray[i];
        }

        for (int i=myArray.length;i<combineArray.length;i++){
            combineArray[i] = alicesArray[i- myArray.length];
        }

        Arrays.sort(combineArray);

        //for (int i = 0, k = 0; i < arr.length; i++) {
           /* for (int i=0,j=0;i<lengthCombine -1;i++){
            if (myArray[j] < alicesArray[j]){
                combineArray[i] = myArray[j];
                myArray = removeTheElement(myArray,j);
            }
            else{
                combineArray[i] = alicesArray[j];
                alicesArray = removeTheElement(alicesArray,j);
            }
        }*/
        return combineArray;
    }

    /*public  static int[] removeTheElement(int[] arr,
                                         int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // return the resultant array
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }
*/


















    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ICMergeSortArray.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}