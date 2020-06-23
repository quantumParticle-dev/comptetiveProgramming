import org.apache.poi.ss.formula.functions.Odd;

import java.util.*;

/**
 * Created by dhuphim on 5/12/20.
 */
public class TestJava {

    public static int maxSumSubArray(int[]nums) {
        //{2, 5, 4, 11, 7, 15}

        //-2,1,-3,4,-1,2,1,-5,4

        int currentSum =0;
        int maxSum =0;
        for (int i =0; i <nums.length; i++){
            currentSum = currentSum + nums[i];
            if (currentSum < 0){
                currentSum =0;
            }
            if (maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        System.out.println("Max Sum is " + maxSum);
         return maxSum;

    }







        //Given nums = [2, 7, 11, 15], target = 9,
        //7>0, 2>1, -2>2, 6>3

        //{2, 5, 4, 11, 7, 15} 2>0, 5>1, 4>2, 11>3, 7>4, 15>5
       /* int targetValue;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            targetValue= target- nums[i];
            if (!indexMap.containsKey(targetValue)){
                indexMap.put(nums[i],i);
            }
            else{
                return new int[] {indexMap.get(targetValue),i};
            }
        }
throw new IllegalArgumentException("Not Found");
    }
*/



    /*public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
        //char [] chArray = theString.toCharArray();
        //civicc

        Set<Character> charTrackerCount = new HashSet<>();
        for (char ch:theString.toCharArray()){
            if (charTrackerCount.contains(ch)){
                charTrackerCount.remove(ch);
            }
            else{
                charTrackerCount.add(ch);
            }
        }
        // the string is a palindrome permutation if it has one or zero characters without a pair.
        //return charCountMap.size()<=1;
   return charTrackerCount.size()<=1;

    }

*/

                //count = charCountMap.get(cha);
//                charCountMap.put(cha, count);
//                System.out.println("If " + cha + " " + count);
//                count=1;

//aabccbdd
            //abcddcba


//        int OddSetCount=0;
//       for (Map.Entry<Character, Integer> entry :charCountMap.entrySet()){
//           if (!(entry.getValue()%2 ==0)){
//               OddSetCount++;
//           }
//        }
//        System.out.println("Total " + OddSetCount);
//        return false;


//        System.out.println("The size " + charCountMap.size());
//        charCountMap.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });
//
//
//        return false;
//





        // method to shuffle an array of size 2n
       /* public static void reverseChars(char[] message, int startIndex, int endIndex){
            while (startIndex < endIndex){
                char temp = message[startIndex];
                message[startIndex] = message[endIndex];
                message[endIndex] = temp;
                startIndex++;
                endIndex--;
                System.out.println(message);
            }
*/
    //            int arr[]={2,3,1,2,4,3}; 7

    //min size subarray with sum >= sum. Dynamic sliding window problem with left size shrinking.
   /* public static int min_sub_array_length(int[] ar, int sum ){

        int minLength= Integer.MAX_VALUE;
        int windowStart =0;
        int currentSum =0;
        for (int windowEnd=0; windowEnd <ar.length;windowEnd++){
          currentSum = currentSum + ar[windowEnd];
            while (currentSum >=sum){
                minLength = Math.min(minLength,windowEnd - windowStart+1 );
                currentSum = currentSum - ar[windowStart];
                windowStart ++;
            }

        }


        return minLength;

}
*/
                //revMessage[len-i-1] = message[i];
                //if (revMessage[len-i-1] == ' '){
                    //markerArray[i] = len-i-1;
                    //System.out.println(markerArray[i]);
                //}

            //String rebuiltString = new String(revMessage);
            //System.out.println(rebuiltString);
            //System.out.println(markerArray);


            // System.out.println(Arrays.asList(message).indexOf('a'));
//String s = new String(message);
//            System.out.println(s);
//            String[] sA= s.split(" ");
//            System.out.println(sA[2]);
            //System.out.println(s.indexOf('c'));
            //System.out.println("Test it " + message.toString());



        // Driver Method
        public static void main(String[] args)
        {
            char a[] = {'c','a','l','c','i',' ','f','o',' ','s','p'};
            int arr[]={2,3,1,2,7,4,3};
            int sum =7;

            maxSumSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

//            int[] sumArray= twoSum(new int[]{2, 5, 4, 11, 7, 15},9);
//            System.out.println("The elements are " + sumArray[0] + " and  " + sumArray[1]);

           //int finalProfit= getMaxProfit(new int[] {9, 7, 4, 1});
            //System.out.println(finalProfit);
            //int minSize = min_sub_array_length(arr,sum);
           // System.out.println("Min size array is " + minSize);

            //boolean isPalindrome = hasPalindromePermutation("aabccbdd");
            //cvivc  ivvvicc//civvvic
            //civvvic

            //ivicc
            //reverseChars(a, 0, a.length - 1);


            //System.out.println(Arrays.toString(a));
        }
    }

