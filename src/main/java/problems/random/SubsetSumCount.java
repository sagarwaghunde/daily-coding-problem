package problems.random;

public class SubsetSumCount {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1, 1, 2, 3};
        int sum = 4;
        
        Integer[][] dp = new Integer[nums.length][sum + 1];
        System.out.println(countSubsets(nums, 0, sum, dp));
    }
    
    static int countSubsets(int[] nums, int index, int sum, Integer[][] dp) {
        if(sum == 0) {
            return 1;
        }
        if(sum < 0 || index == nums.length) {
            return 0;
        }
        if(dp[index][sum] != null) {
            return dp[index][sum];
        }
        dp[index][sum] =  countSubsets(nums, index + 1, sum - nums[index], dp) + countSubsets(nums, index + 1, sum, dp);
        return dp[index][sum];
    }

}
