/*
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by dhuphim on 6/1/20.
 *//*


//https://leetcode.com/problems/replace-the-substring-for-balanced-string/
//QWER
public class LCBalancedString1234 {

    public int balancedString(String s) {
        int actualLength= s.length();
        int perCharFrequency = actualLength/4;
        int count =1;
        Map<Character,Integer> characterMap = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            if (!characterMap.containsKey(s.charAt(i))){
                characterMap.put(s.charAt(i),count);
            }
            else {
                count = characterMap.get(s.charAt(i));
                count++;
                characterMap.put(s.charAt(i), count);
                count =1;
            }
        }

        int Qcount = characterMap.get('Q') - perCharFrequency;

//        characterMap.entrySet().forEach(entry->{
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });


    }




    @Test
    public void shortTest(){
        int actual = balancedString("QWER");
        int expected =0;
        Assert.assertEquals(actual, expected);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LCBalancedString1234.class);
        for (Failure failure: result.getFailures()){
            System.out.println(failure);
        }
        if (result.wasSuccessful()){
            System.out.println("All tests passed");
        }

    }



}
*/
