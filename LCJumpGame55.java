import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
//import org.junit.runner.Result;


/**
 * Created by dhuphim on 6/12/20.
 */
//3,2,1,0,4
    //2,3,1,1,5

    //lgi: 4
    //4
//4 +4 >=4
    //

//23115
    //lg=4
    //5+4 >4 > lg=4
    //3+1>4

//https://leetcode.com/problems/jump-game/
//https://www.youtube.com/watch?v=Zb4eRjuPHbM
public class LCJumpGame55 {

    public boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length -1;
        for (int i= nums.length -1; i>=0; i--){
            if (i + nums[i] >= lastGoodIndex){
                lastGoodIndex =i;
            }

        }
        return lastGoodIndex ==0;
    }




    @Test
    public void shortTest(){
        boolean actual = canJump(new int[]{2,3,1,1,5});
        boolean expected = true;
        Assert.assertEquals(actual,expected);
    }



    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCJumpGame55.class);
        for (Failure failure: result.getFailures()){
            System.out.println(failure);
        }
        if (result.wasSuccessful()){
            System.out.println("All tests passed");
        }


    }

}
