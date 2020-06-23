import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by dhuphim on 5/17/20.
 */
public class LCLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
//abcabcbb
        Set<Character> stringIndexSet = new HashSet<>();
        char[] chArray = s.toCharArray();
        int windowStart = 0;
        int windowEnd =0;
        int maxLenth = 0;
//        String subString= " ";
//        char[] chSurrected; //abcabcbb

        while (windowEnd < chArray.length){
            if (!stringIndexSet.contains(chArray[windowEnd])){
                stringIndexSet.add(chArray[windowEnd]);
                windowEnd++;
                maxLenth = Math.max(maxLenth,stringIndexSet.size());
            }
            else{
                stringIndexSet.remove(chArray[windowStart]);
                windowStart++;
                //windowEnd++;
            }
        }
        //System.out.println("String array is " + chArray[windowStart] + " , " + chArray[windowStart +1]+ " , "+ chArray[windowStart+2] );
        return maxLenth;
    }

    @Test
    public void shortArrayTest() {
        final int actual = lengthOfLongestSubstring("abcabcbde");
        final int expected = 4;
        assertEquals(expected, actual);
    }


    // Driver Method
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCLongestSubstring.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All Tests passed");
        }

    }
}