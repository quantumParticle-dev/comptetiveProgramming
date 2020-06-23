import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ICPalindromeStringPermutation {

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
        //char [] chArray = theString.toCharArray();
        // check if any permutation of the input is a palindrome
        //char [] chArray = theString.toCharArray();
        if ((theString.isEmpty()|| theString == null)) {
            return true;

        }

            int count = 1;
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (char cha : theString.toCharArray()) {
                if (charCountMap.containsKey(cha)) {
                    count = charCountMap.get(cha);
                    //System.out.println(cha + " "+ count);
                    count++;
                }
                //count = charCountMap.get(cha);
                charCountMap.put(cha, count);
                //System.out.println("If " + cha + " " + count);
                count = 1;
            }
            int oddSetCount = 0;
            for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                if (!(entry.getValue() % 2 == 0)) {
                    oddSetCount++;
                }
            }
            if (oddSetCount == 1 || oddSetCount ==0) {
                return true;
            } else {
                //System.out.println("Total " + OddSetCount);
                return false;
            }


    }


    // tests

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ICPalindromeStringPermutation.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }
}