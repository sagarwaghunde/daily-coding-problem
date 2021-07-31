package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndMaxIncreasingSubsequence {
    public static void main(String[] args) {
//        int[] input = {0, 8, 4, 12, 2, 10, 6,     14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] input = {1,3,6,7,9,4,10,5,6};
        int maxLength = 0;
        for(int i = 0; i < input.length; i++) {
            if (input.length - i < maxLength) {
                break;
            }
            int length = maxIncreasingSubsequenceLength(input, input[i], i+1, 1, maxLength);
//            List<Integer> sequence = new ArrayList<>();
//            sequence.add(input[i]);
//            int length = maxIncreasingSubsequenceLength(input, sequence, input[i], i+1, 1, maxLength);
            maxLength = Math.max(maxLength, length);
        }
        String s = "";
        System.out.println(maxLength);
        StringBuffer sb = new StringBuffer();
    }
    
    static int maxIncreasingSubsequenceLength(int[] input, int prevValue, int nextIndex, int length, int maxLength) {
        if(nextIndex >= input.length) {
            return Math.max(length, maxLength);
        }
        for(int i = nextIndex; i < input.length; i++) {
            if (prevValue < input[i]) {
                // Get max length by considering current element
                int lengthWithCurrent = maxIncreasingSubsequenceLength(input, input[i], i+1, length + 1, maxLength);
                // if length by considering current element is greater than or equal to :
                // remaining elements to be scanned - 1, here (-1 cause next method will check without current element)
                // Treat lengthWithCurrent element as maxLength
                if (lengthWithCurrent >= input.length - nextIndex) {
                    return lengthWithCurrent;
                }
                // Get max length without considering current element
                int lengthWithoutCurrent = maxIncreasingSubsequenceLength(input, prevValue, i+1, length, maxLength);
                // get max of above
                maxLength = Math.max(lengthWithCurrent, maxLength);
                maxLength = Math.max(lengthWithoutCurrent, maxLength);
            }
        }
        return Math.max(length, maxLength);
    }
    
    static int maxIncreasingSubsequenceLength(int[] input, List<Integer> sequence, int prevValue, int nextIndex, int length, int maxLength) {
        if(nextIndex >= input.length) {
            System.out.println(Arrays.toString(sequence.toArray()));
            return Math.max(length, maxLength);
        }
        for(int i = nextIndex; i < input.length; i++) {
            if (prevValue < input[i]) {
                sequence.add(input[i]);
                int withLength = maxIncreasingSubsequenceLength(input, sequence, input[i], i+1, length + 1, maxLength);
                if (withLength >= input.length - nextIndex) {
                    return withLength;
                }
                sequence.remove(sequence.size() - 1);
                int withoutLength = maxIncreasingSubsequenceLength(input, sequence, prevValue, i+1, length, maxLength);
                maxLength = Math.max(maxLength, Math.max(withLength, withoutLength));
            }
        }
        return Math.max(length, maxLength);
    }
}
