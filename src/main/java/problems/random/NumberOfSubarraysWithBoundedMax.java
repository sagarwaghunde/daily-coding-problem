package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSubarraysWithBoundedMax {
    public static void main(String[] args) {
        int left = 2;
        int right = 8;
        //int[] nums = {2, 1, 4, 3};
        int[] nums = {2, 9, 2, 1, 5, 6};
        
        System.out.println(numSubarrayBoundedMax(nums, left, right));
        System.out.println(numSubarrayBoundedMaxDP(nums, left, right));
    }
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result=0, left=-1, right=-1;
        for (int i=0; i<A.length; i++) {
            if (A[i]>R) left=i;
            if (A[i]>=L) right=i;
            result+=right-left;
        }
        return result;
    }
    
    public static int numSubarrayBoundedMaxDP(int[] A, int L, int R) {
        int length = A.length;
        int[][] dp =new int[length][length];
        for(int i = 0; i < length; i++) {
            for(int j = i+1; j < length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], A[j]);
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        int ans = 0;
        for(int i = 0; i < length; ++i)
        {
            for(int j = i; j < length; ++j)
                if (dp[i][j] >= L && dp[i][j] <= R) ans++;
        }
        return ans;
    }
}
