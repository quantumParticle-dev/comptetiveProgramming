import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dhuphim on 12/29/19.
 */
public class LeetCodeLongestSubstring {

    public static void main(final String[] args) {

        int length = 0;
        System.out.println("In Main");
        length = lengthOfLongestSubstring("abcabcbb");
        System.out.println("Length " + length);

    }

    public static int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int i = 0;
        int j = 0;
        int count = 0;
        Set hashset = new HashSet<String>();
        while (j < len) {
            //abcabcbb

            if (!hashset.contains(s.charAt(j))) {
                System.out.println("In first " + s.charAt(j));
                hashset.add(s.charAt(j));
                //i++;
                j++;
            } else {
                hashset.remove(s.charAt(i));
                //System.out.println("In second i " + s.charAt(i));
                System.out.println("In second " + s.charAt(j));
                //hashset.add(s.charAt(j));
                //j++;
                i++;
            }

        }
        System.out.println("Size " + Arrays.toString(hashset.toArray()));
        return hashset.toArray().length;

    }

}
