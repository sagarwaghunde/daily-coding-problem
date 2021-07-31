package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {
    public static void main(String[] args) {
        int[] pieces = {1, 2, 3, 4, 5};
        int[] profits = {2, 6, 7, 10, 13};
        Integer[][] dp = new Integer[pieces.length][pieces.length + 1];
        List<Integer> indices = new ArrayList<>();
        System.out.println(getProfitFromPieces(pieces, profits, pieces.length, 0, dp, indices));
        System.out.println(Arrays.toString(indices.toArray()));
    }
    
    public static int getProfitFromPieces(int[] pieces, int[] profits, int remainingLength, int index, Integer[][] dp, List<Integer> indices) {
        if(remainingLength == 0 || index == pieces.length) {
            System.out.println(Arrays.toString(indices.toArray()));
            return 0;
        }
        int profit1 = 0;
//        if(dp[index][remainingLength] != null) {
//            System.out.println("Found in array");
//            return dp[index][remainingLength];
//        }
        if(pieces[index] <= remainingLength) {
            indices.add(index);
            profit1 = profits[index] + getProfitFromPieces(pieces, profits, remainingLength - pieces[index], index, dp, indices);
            indices.remove(indices.size() - 1);
        }
        
        int profit2 = getProfitFromPieces(pieces, profits, remainingLength, index + 1, dp, indices);
//        if(profit1 > profit2) {
//            indices.add(index);
//        }
        dp[index][remainingLength] = Math.max(profit1, profit2);
        return Math.max(profit1, profit2);
    }
}
