package problems.random;

import java.util.Arrays;

public class FindLongestMountainInArray {
    public static void main(String[] args) {
//        int[] input = {3, 1, 2, 3, 4, 2, 1, 8};
//        int[] input = {2,1,4,7,3,2,5};
        int[] input = {2, 2, 2};
        System.out.println(Arrays.toString(input) + " : " + getLongestMountainLength(input));
        System.out.println("Effective : " + getLongestMountainLengthEffective(input));
    }
    
    static int getLongestMountainLength(int[] input) {
        int maxLength = 0;
        for(int i = 0; i < input.length; i++) {
            int left = i;
            int right = i;
            while(left > 0 && input[left] > input[left - 1]) {
                left--;
            }
            while(left != i && right + 1< input.length && input[right] > input[right + 1]) {
                right++;
            }
            int length = left == i || right == i ? 0 : right - left + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
    
    static int getLongestMountainLengthEffective(int[] input) {
        if (input.length < 3) {
            return 0;
        }
        int left = 0; 
        int right;
        int maxLength = 0;
        while(left < input.length - 2) {
            while(left + 1 < input.length && input[left] >= input[left+1]) {
                left++;
            }
            right = left + 1;
            while(right + 1 < input.length && input[right] < input[right+1]) {
                right++;
            }
            while(right + 1 < input.length && input[right] > input[right+1]) {
                right++;
                maxLength = Math.max(maxLength, right - left + 1);
            }
            left = right;
        }
        return maxLength;
    }
}
