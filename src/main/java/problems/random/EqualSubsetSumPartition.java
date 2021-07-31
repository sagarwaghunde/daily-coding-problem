package problems.random;

public class EqualSubsetSumPartition {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(canDivideIntoEqualSubsets(nums));
    }
    
    public static boolean canDivideIntoEqualSubsets(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        Boolean[][] dp = new Boolean[nums.length][sum/2 + 1];
        return canDivideIntoEqualsSubsets(nums, 0, sum/2, dp);
    }
    
    public static boolean canDivideIntoEqualsSubsets(int[] nums, int index, int sum, Boolean[][] dp) {
        if(sum == 0) {
            return true;
        }
        if(0 == nums.length || index == nums.length) {
            return false;
        }
        if(dp[index][sum] == null) {
            if(nums[index] <= sum) {
                if(canDivideIntoEqualsSubsets(nums, index + 1, sum - nums[index], dp)) {
                    dp[index][sum] = true;
                    return true;
                }
            }
            dp[index][sum] = canDivideIntoEqualsSubsets(nums, index + 1, sum, dp);
        }
        return dp[index][sum];
    }
}
