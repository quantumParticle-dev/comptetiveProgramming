/**
 * Created by dhuphim on 1/30/18.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//import java.util.logging.Logger;


public class LeetCodeSum {


    public static void main(final String[] args) throws Exception {
        int[] nums = {2, 11, 7, 15};
        int[] numsResult;
        int target = 9;
        numsResult = twoSum(nums, target);
        System.out.println(Arrays.toString(numsResult));


    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        // List <Integer> lArray = new ArrayList <Integer>();
        //int[] iArray;
        Map<Integer, Integer> uMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            if (!uMap.containsKey(diff)) {
                uMap.put(nums[i], i);
                //return new int[]{};
            } else {
                int index = uMap.get(diff);
                //System.out.println("Here are " + nums[index] + "And " + nums[i]);
                //int [] arr = {nums[index],nums[i]};
                //lArray.add(nums[index]);
                //lArray.add(nums[i]);
                return new int[]{index, i};
            }

        }
        return new int[]{};
    }
}



