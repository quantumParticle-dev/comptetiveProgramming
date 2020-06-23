/**
 * Created by dhuphim on 12/19/19.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TestSteps {

    // Complete the countingValleys function below.
    static void countingValleys(int n, String s) {

        int Diff = 0;
        char[] ar = s.toCharArray();
        int len = ar.length;
        // System.out.println("Hey "+len);
        int[] aray = new int[len+1];
        System.out.println("Hey " + aray.length);
        //System.out.println(aray.toString());
        aray[0] =0;
        for (int i = 1; i < len+1; i++) {
            if (ar[i - 1] == 'U') {
                aray[i] = aray[i - 1] + 1;
            } else {
                aray[i] = aray[i - 1] - 1;
            }
            if (aray[i] == 0 && aray[i - 1] == -1) {
                Diff++;

            }
        }
        System.out.println(Arrays.toString(aray));
        System.out.println(Diff);

        }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        countingValleys(n, s);
        //System.out.println("Result "+result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }
}

