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

    public class TestRepeatString {

        // Complete the repeatedString function below.
        static long repeatedString(String s, long n) {
            long len = s.length();
            int countForOne = 0;
            long totalCount = 0;
            long remCount = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == 'a') {
                    countForOne++;
                }
            }
            long freq = n / len;
            long rem = n % len;

            for (int j = 0; j < rem; j++) {

                if (s.charAt(j) == 'a') {

                    remCount++;
                }

            }
            totalCount = freq * countForOne + remCount;
            System.out.println(totalCount);
            return totalCount;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
           // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scanner.nextLine();

            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = repeatedString(s, n);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
//
//            bufferedWriter.close();

            scanner.close();
        }
    }

