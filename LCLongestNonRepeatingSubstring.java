import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dhuphim on 5/22/20.
 */
public class LCLongestNonRepeatingSubstring {



    //abcabcbb
public static int LongestSubstring(String st){
    int windowStart =0;
    int windowEnd =0;
    int maxLength= Integer.MIN_VALUE;
    Set<Character> subStringSet = new HashSet<>();

    if (st.isEmpty()){
        return 0;
    }

    while (windowEnd <st.length()){
        if (!subStringSet.contains(st.charAt(windowEnd))){
            subStringSet.add(st.charAt(windowEnd));
            windowEnd++;
            maxLength = Math.max(subStringSet.size(), maxLength);
        }
        else{
            subStringSet.remove(st.charAt(windowStart));
            windowStart++;
        }
    }
    System.out.println("Max Non repeating Substring's length is " + maxLength);
    return maxLength;
}




@Test
public void ShortTest(){
    int actual = LongestSubstring("");
    int expected = 0;
    Assert.assertEquals(actual, expected);
}



public static void main(String[] args){

    Result result = JUnitCore.runClasses(LCLongestNonRepeatingSubstring.class);
    for (Failure failue: result.getFailures()){
        System.out.println(failue);
    }
    if (result.wasSuccessful()){
        System.out.println("All tests passed");
    }


}

}