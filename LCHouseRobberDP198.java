import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by dhuphim on 5/25/20.
 */
public class LCHouseRobberDP198 {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length ==1){
            return nums[0];
        }
        if (nums.length ==2){
            return Math.max(nums[1], nums[0]);
        }
//[1,2,3,1]
        //2,7,9,3,1,7
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        //dp[2] = Math.max (nums[0] + nums[2], nums[1]);
        for (int i=2; i<nums.length; i++){
            dp[i] = Math.max((dp[i -2]+ nums[i]),(dp[i-1]));
        }
        return dp[nums.length -1];
        //dp[2] = 11 or 7 ==11
        //dp[3] = 7+3 or 9 ==10
        //dp[4] = 9+1 or 3 =10
    }



    @Test
    public void shortTest(){
        int actual = rob(new int[]{2,7,9,3,1});
        int expected = 12;
        Assert.assertEquals(actual,expected);
    }



    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCHouseRobberDP198.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure);
        }
        if (result.wasSuccessful()){
            System.out.println("All tests passed");
        }


    }







}
