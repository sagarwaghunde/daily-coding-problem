package problems.range_475_500;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortedArrayBounds_498 {
    public static void main(String[] args) {
        //int[] input = {3, 7, 5, 6, 9};
        int[] input = {1, 4, 5, 9, 2, 18, 3, 29, 30};
//        int[] input = {1, 2, 3, 4};
//        int[] input = {2, 1};
        printArrayInBothDirections(input);
        printUnsortedBoundsBySortMethod(input);
        printUnsortedBoundsWithoutSorting(input);
        System.out.println(findUnsortedSubarray(input));
        System.out.println(findUnsortedSubarrayInOneLoop(input));
        
    }
    public static void printArrayInBothDirections(final int[] input) {
        for(int i = 0; i < input.length; i++) {
            System.out.println(input[i] + ":" + input[input.length - 1 - i]);
        }
    }
    
    public static void printUnsortedBoundsBySortMethod(final int[] input) {
        int[] sortedInput = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedInput);
        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Sorted : " + Arrays.toString(sortedInput));
        
        int leftBound = -1;
        int rightBound = -1;
        for(int i = 0; i < input.length; i++) {
            if (input[i] != sortedInput [i]) {
                if (leftBound == -1) {
                    leftBound = i;
                } else {
                    rightBound = i;
                }
            }
        }        
        System.out.println(leftBound + " - " + rightBound);
    }
    
    public static void printUnsortedBoundsWithoutSorting(final int[] input) {
        int left = -1;
        int right = -1;
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        for(int i = 0; i < input.length; i++) {
            MAX = Math.max(MAX, input[i]);
            if (input[i] < MAX) {
                right = i;
            }
        }
        for(int i = input.length - 1; i >=0; i--) {
            MIN = Math.min(MIN, input[i]);
            if(input[i] > MIN) {
                left = i;
            }
        }
        System.out.println(left + " - " + right);
    }
    
    public static int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int right = -1;
        if (nums[0] > nums[nums.length - 1]) {
            return nums.length;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                right = i;
            }
        }
        
        for(int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                left = i;
            }
        }
        int value = 0;
        if (left == -1 && right == -1) {
            value = 0;
        } else {
            value = right - left + 1;
        }
        return value;
    }
    
    public static int findUnsortedSubarrayInOneLoop(int[] nums) {
        int left = -1;
        int right = -2;
        int min = nums[nums.length - 1];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                right = i;
            }
            min = Math.min(min, nums[nums.length - 1 - i]);
            if (nums[nums.length - 1 - i] > min) {
                left = nums.length - 1 - i;
            }
        }
        return right - left + 1;
    }
}
