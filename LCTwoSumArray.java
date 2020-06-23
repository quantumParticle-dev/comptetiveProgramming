import org.apache.poi.ss.formula.functions.Odd;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by dhuphim on 5/12/20.
 */
public class LCTwoSumArray {

    public static int[] twoSum(int[]nums , int target) {

        //Given nums = [2, 7, 11, 15], target = 9,
        //7>0, 2>1, -2>2, 6>3

        //{2, 5, 4, 11, 7, 15} 2>0, 5>1, 4>2, 11>3, 7>4, 15>5
        int targetValue;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            targetValue= target- nums[i];
            if (!indexMap.containsKey(targetValue)){
                indexMap.put(nums[i],i);
            }
            else{
                return new int[] {indexMap.get(targetValue),i};
            }
        }
        throw new IllegalArgumentException("Not Found");
    }



    @Test
    public void shortArrayTest() {
        final int[] actual = twoSum(new int[]{2, 5, 4, 11, 7, 15}, 9);
        final int[] expected = new int[]{1, 2};
        assertArrayEquals(expected, actual);
    }


    // Driver Method
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(LCTwoSumArray.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()){
            System.out.println("All Tests passed");
        }

    }
}

