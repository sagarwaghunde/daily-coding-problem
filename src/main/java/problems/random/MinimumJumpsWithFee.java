package problems.random;

public class MinimumJumpsWithFee {
    
    public static void main(String[] args) {
//        int[] fees = {1,2,5,2,1,2};
        int[] fees = {2,3,4,5};
        System.out.println(minFee(fees));
        System.out.println(minFeeRecursive(fees, 0));
        String input = "sagar";
    }
    
    static int minFee(int[] fees) {
        int[] dp = new int[fees.length];
        dp[0] = fees[0];
        for(int i = 1; i < fees.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int start = 1; start < fees.length; start++) {
            for(int j = 1; j <= 3 && fees[start] + j < fees.length && start+j < fees.length; j++) {
                dp[fees[start]+j] = Math.min(dp[fees[start]+j], fees[start] + fees[start+j]);
            }
        }
        return dp[fees.length - 1];
    }
    
    static int minFeeRecursive(int[] fees, int index) {
        if(index >= fees.length) {
            return 0;
        }
        int step1 = minFeeRecursive(fees, index + 1);
        int step2 = minFeeRecursive(fees, index + 2);
        int step3 = minFeeRecursive(fees, index + 3);
        
        int minSteps = Math.min(step3, Math.min(step1, step2));
        return fees[index] + minSteps;
    }
}
