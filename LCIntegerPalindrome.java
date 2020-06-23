import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/**
 * Created by dhuphim on 5/21/20.
 */
public class LCIntegerPalindrome {

    public boolean isPalindrome(int x) {

        int original = x;
        int reversed = 0;
        if (x < 0) {
            return false;
        }
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        //System.out.println(reversed);
        return (original == reversed);
    }


    @Test
    public void shortIntegerTest() {
        final boolean actual = isPalindrome(1000000045);
        final boolean expected = false;
        assertEquals(actual, expected);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCIntegerPalindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed");
        }


    }


}
