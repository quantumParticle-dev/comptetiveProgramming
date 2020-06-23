import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by dhuphim on 5/23/20.
 */
public class LCFibbonacci509 {


    public int fib(int N) {
        int[] fibSum = new int[N+2];
        //why N+2? Because, if N =0, the fibSum array can only accomodate 1 element fibsum[O]. But here we're trying to
        //initialize fubSum[1] also in an array with only 0 index available. Hence ArrayIndexOutofBound exception will come on run time.
        fibSum[0]= 0;
        fibSum[1] =1;
        for (int i=2;i<N+1; i++){ //  2<4 ; f[2] = 2; 3<4; 2+1 3+2
            fibSum[i] = fibSum[i-1] + fibSum[i-2]; //f[3] = f[2] +f[1] ; f[2];
        }
        System.out.println(fibSum[N]);
        return fibSum[N];
    }



    /* This one is O(N) time and O(1) space complexity. The above one is O(N) time and O(N) space.
    static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }*/


    @Test
    public void shortTest(){
        int actual = fib(4);
        int expected = 3;
        Assert.assertEquals(actual,expected);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCFibbonacci509.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure);
        }
        if (result.wasSuccessful()){
            System.out.println("All tests passed");
        }

    }


}
