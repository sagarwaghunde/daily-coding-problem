package problems.leetcode.daily.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class ShortestUnsortedSubarray {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[] nums = {2,6,4,1,1, 8,10,9,15};
//        int[] nums = {1,3,2,3,3};
        int[] nums = {1,3,2,2,2};
        
        System.out.println(findUnsortedSubarray(nums));
    }
    
    
    public static int findUnsortedSubarray(int[] nums) {
        int left=0;
        while(left < nums.length - 1) {
            if(nums[left + 1] < nums[left]) {
                break;
            }
            left++;
        }
        if(left == nums.length) {
            return 0;
        }
        int right = nums.length - 1;
        while(right > 0) {
            if(nums[right - 1] > nums[right]) {
                break;
            }
            right--;
        }
        int subArrayMin = Integer.MAX_VALUE;
        int subArrayMax = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++) {
            subArrayMin = Math.min(subArrayMin, nums[i]);
            subArrayMax = Math.max(subArrayMax, nums[i]);
        }
        while(left > 0 && nums[left - 1] > subArrayMin) {
            left--;
        }
        while(right < nums.length - 1 && nums[right+1] < subArrayMax) {
            right++;
        }
        return right - left + 1;
    }
}


