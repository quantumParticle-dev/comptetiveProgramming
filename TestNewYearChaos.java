/**
 * Created by dhuphim on 12/23/19.
 */
    import java.security.*;
    import java.io.*;
    import java.math.*;
    import java.text.*;
    import java.util.*;
    import java.util.concurrent.*;
    import java.util.regex.*;

    public class TestNewYearChaos {

        // Complete the minimumBribes function below.
        static void minimumBribes(int[] q) {

            int len = q.length;
            int countBribe = 0;
            int jumpCount = 0;
            for (int i = len - 1; i > 0; i--) {
                jumpCount = q[i] - q[i - 1];

                if (jumpCount > -3 && jumpCount < 0) {
                    countBribe = countBribe + jumpCount;

                } else if (jumpCount < -3) {
                    System.out.println("Too Chaotic");
                }
                else {
                    System.out.println("No Bribe");
                }

            }
            System.out.println("Valid Bribe with bribe count "+ Math.abs(countBribe));
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] q = new int[n];

                String[] qItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qItems[i]);
                    q[i] = qItem;
                }

                minimumBribes(q);
            }

            scanner.close();
        }
    }


