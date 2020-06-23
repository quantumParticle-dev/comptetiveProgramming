import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by dhuphim on 5/22/20.
 */
public class LCContainerMaxAreaSlidingWindow {

    public static int maxArea(int[] height) {
        int startIndex =0;
        int endIndex = height.length -1;
        int maxArea = 0;
        while (startIndex < endIndex){
            maxArea = Math.max((Math.min(height[startIndex], height[endIndex]) * (endIndex - startIndex)), maxArea);
            if (height[startIndex] < height[endIndex]){
                startIndex++;
            }
            else{
                endIndex --;
            }
        }
        //System.out.println("Max Area  " + maxArea);
    return maxArea;
    }





    @Test
    public void ShortValueTest(){
        int actual = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        int expected = 49;
        Assert.assertEquals(actual, expected);
        //assertEquals(actual, expected);
    }


    public static void main(String[] args){
        Result result = JUnitCore.runClasses(LCContainerMaxAreaSlidingWindow.class);
        for (Failure failure: result.getFailures()){
            System.out.println(failure);
        }
         if (result.wasSuccessful()){
             System.out.println("All tests passed");
         }

    }



}
