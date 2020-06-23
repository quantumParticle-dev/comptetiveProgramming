import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Arrays;

/**
 * Created by dhuphim on 5/24/20.
 */
public class LCLongestPalindromeSubstring5 {



    public static String longestPalindrome(String s) {
//babad >> bab or aba

        String[] pal = new String[s.length()+2];
        pal[0] = pal[1];

        return null;
    }


    public static String palindromeString(String subString){

        char[] sub = new char[subString.length()];

           for (int i=0; i<subString.length(); i++){
               sub[i] = subString.charAt(subString.length()-i-1);
           }
           return new String(sub);
    }



    @Test
    public void shortDataTest(){
        String actual = longestPalindrome("babad");
        String expected = "bab";
        Assert.assertEquals(actual, expected);
    }



    public static void main(String[] args) {
        /*Result result = JUnitCore.runClasses(LCLongestPalindromeSubstring5.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure);
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed");
        }*/

        String finalStr = longestPalindrome("Hello how are you");
        System.out.println(finalStr);

    }





}
