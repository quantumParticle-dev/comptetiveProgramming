import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by dhuphim on 5/31/20.
 */

/*
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
        Medium
        Given an array of integers nums and an integer limit, return the size of the longest continuous subarray such that the absolute difference between any two elements is less than or equal to limit.

        In case there is no subarray satisfying the given condition return 0.
*/


/*Example 1:

        Input: nums = [8,2,4,7], limit = 4
        Output: 2
        Explanation: All subarrays are:
        [8] with maximum absolute diff |8-8| = 0 <= 4.
        [8,2] with maximum absolute diff |8-2| = 6 > 4.
        [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
        [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
        [2] with maximum absolute diff |2-2| = 0 <= 4.
        [2,4] with maximum absolute diff |2-4| = 2 <= 4.
        [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
        [4] with maximum absolute diff |4-4| = 0 <= 4.
        [4,7] with maximum absolute diff |4-7| = 3 <= 4.
        [7] with maximum absolute diff |7-7| = 0 <= 4.
        Therefore, the size of the longest subarray is 2.
    */



public class LCContiguousSubArray1438 {

    //Input: nums = [8,2,4,7], limit = 4
    public int longestSubarray(int[] nums, int limit) {
        int startIndex=0;
        int endIndex;
        int maxLength =0;
        for (endIndex =0; endIndex<nums.length;endIndex++){
            if (Math.abs(nums[startIndex] - nums[endIndex])> limit){
                startIndex++;
                endIndex --;
            }
            maxLength = Math.max(maxLength, endIndex - startIndex+1);
                //endIndex++;
        }
        System.out.println(maxLength);
        return (maxLength);

    }



    @Test
    public void shortTest() {
        final int expected = longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0);
        final int actual = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void otherTest(){

        final int expected = longestSubarray(new int[]{4,8,5,1,7,9}, 6);
        final int actual = 3;
        Assert.assertEquals(expected, actual);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCContiguousSubArray1438.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed");
        }
    }




}
