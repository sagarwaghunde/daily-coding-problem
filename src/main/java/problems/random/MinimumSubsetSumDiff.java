package problems.random;

import java.util.Arrays;

public class MinimumSubsetSumDiff {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 9};
        int sum = Arrays.stream(nums).sum();
        Integer[][] dp = new Integer[nums.length][sum + 1];
        System.out.println(diff(nums, 0, 0, 0, dp));
    }
    
    static int diff(int[] nums, int index, int sum1, int sum2, Integer[][] dp) {
        if(nums.length == 0 || index == nums.length) {
            return Math.abs(sum1 - sum2);
        }
        int diff = Math.abs(sum1 - sum2);
        if(dp[index][diff] != null) {
            return dp[index][diff];
        }
        int diff1 = diff(nums, index + 1, sum1 + nums[index], sum2, dp);
        int diff2 = diff(nums, index + 1, sum1, sum2 + nums[index], dp);
        dp[index][diff] = Math.min(diff1, diff2);
        return dp[index][diff];
    }

}
