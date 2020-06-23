import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by dhuphim on 5/23/20.
 */
public class LCTribonacci1137 {

    public int tribonacci(int n) {
        //T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

        int[] T = new int[n+3];
        T[0] =0;
        T[1] =1;
        T[2] =1;
        for (int i=3; i<n+3; i++){
            T[i] = T[i-1]+ T[i-2]+ T[i-3];
        }
        return T[n];

    }



@Test
public void shortTest(){
    int actual = tribonacci(4);
    int expected = 4;
    Assert.assertEquals(actual,expected);
}


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCTribonacci1137.class);
        for (Failure failure: result.getFailures()){
            System.out.println(failure);
        }
        if (result.wasSuccessful()){
            System.out.println("All tests passed");
        }

    }

}
