package problems.random;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubsequence {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
        //int[] input = {5, 4, 202, 200, 1, 201, 2, 199};
         int[] input = {6, 5, 1, 4, 3, 7};
//        int[] input = {6,5,1,4,9,7,3};
        int maxLength = Integer.MIN_VALUE;
        Map<Integer, Integer> sequneceLengthMap = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            // i-1
            int lowerValue= sequneceLengthMap.getOrDefault(input[i]-1, 0);
            // i+1
            int upperValue= sequneceLengthMap.getOrDefault(input[i]+1, 0);
            int lengthAtThisIndex = lowerValue + upperValue + 1;
            sequneceLengthMap.put(input[i], lengthAtThisIndex);
            maxLength = Math.max(lengthAtThisIndex, maxLength);
            sequneceLengthMap.put(input[i]-lowerValue, lengthAtThisIndex);
            sequneceLengthMap.put(input[i]+upperValue, lengthAtThisIndex);
        }
        System.out.println(maxLength);
    }
    
}
