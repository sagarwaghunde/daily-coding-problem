package problems.random;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3};
        int sum = 43;
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        System.out.println(hasValidSubsetSum(nums, sum, 0, dp));
    }
    
    static boolean hasValidSubsetSum(int[] nums, int sum, int index, Boolean[][] dp) {
        if(sum < 0) {
            return false;
        }
        if(sum == 0) {
            return true;
        }
        if(nums.length == 0 || index == nums.length) {
            return false;
        }
        if(dp[index][sum] != null) {
            System.out.println("Found in array");
            return dp[index][sum];
        }
        dp[index][sum] = hasValidSubsetSum(nums, sum - nums[index], index+1, dp) || hasValidSubsetSum(nums, sum, index+1, dp);
        return dp[index][sum];
    }
}
