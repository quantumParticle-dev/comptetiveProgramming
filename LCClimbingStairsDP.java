import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * Created by dhuphim on 5/23/20.
 */
public class LCClimbingStairsDP {

    public int climbStairs(int n) {
        int[] stairs = new int[n+1]; //n+1 because there is stairs[o] index too.
        stairs[0]=1;
        stairs[1]=1;
        for (int i=2; i< n+1; i++){
            stairs[i] = stairs[i-1] + stairs[i-2]; // s[2] = 2, s[3] = 2+1, s[4] = 3+2
            //System.out.println(stairs[i]);
        }
        //System.out.println("Todal ways " + stairs[n]);
        return stairs[n];
    }




    @Test
    public void shortTest(){
        int actual = climbStairs(5);
        int expected = 8;
        Assert.assertEquals(actual,expected);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCClimbingStairsDP.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure);
        }

        if (result.wasSuccessful()){
            System.out.println("All tests passed");
        }
    }

}



