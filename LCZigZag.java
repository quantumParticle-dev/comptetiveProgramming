import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by dhuphim on 5/20/20.
 */
public class LCZigZag {

    public static String convert(String s, int numRows) {

        boolean down = true;
        int rowNum =0;
        String[] zigZagArray = new String[numRows];
        Arrays.fill(zigZagArray, "");
        for (int i=0; i<s.toCharArray().length; i++){
            zigZagArray[rowNum] = zigZagArray[rowNum] + s.charAt(i);

            if (rowNum == numRows -1){
                down = false;
            }
            else if (rowNum ==0){
                down = true;
            }
             if (down){
                 rowNum++;
             }
            else
             {
                 rowNum --;
             }
        }

        System.out.println("Hello  " + Arrays.toString(zigZagArray));
        return Arrays.toString(zigZagArray);

    }



//    @Test
//    public void shortArrayTest() {
//        final String actual = convert("PAYPALISHIRING", 4);
//        final String expected = "PINALSIGYAHRPI";
//       assertEquals(expected, actual);
//    }


    // Driver Method
    public static void main(String[] args)
    {



        convert("PAYPALISHIRING",4);



//        Result result = JUnitCore.runClasses(LCZigZag.class);
//        for (Failure failure:result.getFailures()){
//            System.out.println(failure.toString());
//        }
//        if (result.wasSuccessful()){
//            System.out.println("All Tests passed");
//        }

    }
}
