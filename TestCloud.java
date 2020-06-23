/**
 * Created by dhuphim on 12/20/19.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TestCloud {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
//        List<Integer> list1 = new LinkedList<Integer>();
//        list1.add(0);
        int len = c.length;
        int i=0;
        int numJumps=0;
        while (i<len-1){
            if (i+2 ==len || (c[i+2] ==1 && c[i+1]==0)){
                i++;
                numJumps++;
            }
            else{
                i += 2;
                numJumps++;
            }
        }
        System.out.println(numJumps);
   return numJumps;

        }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("/Users/dhuphim/StandAloneJava/src/out.txt")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
