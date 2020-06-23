import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TestString {

    // Complete the sockMerchant function below.

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        //Set<Integer> h = new Hashset();
        //6 5 2 3 5 2 2 1 1 5 1 3 3 3 5
        int pair = 0;
        for (int i = 0; i < ar.length; i++) {
            if (!h.containsKey(ar[i])) {
                h.put(ar[i], 1);
            } else {
                System.out.println(ar[i]);
                h.remove(ar[i]);
                pair++;

            }

        }
        return pair;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
