package problems.random;

import java.util.Arrays;

public class FindMissingPositveInteger {
    public static void main(String[] args) {
        int[] nums = {4, 7,8,9,11,12};
        
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                System.out.println("nums[i] = " + nums[i]);
                System.out.println("nums[nums[i] - 1] = " + nums[nums[i] - 1]);
                swap(nums, i, nums[i] - 1);
                System.out.println(Arrays.toString(nums));
            }
        }
    }
    
    static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
