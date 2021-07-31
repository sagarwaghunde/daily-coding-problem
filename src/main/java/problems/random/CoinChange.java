package problems.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CoinChange {
    public static void main(String[] args) {
/**
 * [186,419,83,408]
6249
 */
        
//        int[] coins = {186,419,83,408};
//        int sum = 6249;
        int[] coins = {1, 2, 3};
        int sum = 7;
        System.out.println("DP : " + getTotalCoins(coins, sum));
        System.out.println("BFS : " + getTotalCoinsByBfs(coins, sum));
        System.out.println("Knapsack : " + knapsackCoinChange(coins, 0, sum));
        System.out.println("BottomUpCoinChang : " + dpBottomUpCoinChang(coins, sum));
    }
    
    static int getTotalCoins(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        for(int i = 1; i <= amount; i++) {
            minCoins[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i && minCoins[i - coins[j]] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }
        if (minCoins[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return minCoins[amount];
    }
    
    static int getTotalCoinsByBfs(int[] coins, int amount) {
        // Queue to maintain various remaining amounts
        Queue<Integer> queue = new LinkedList<>();
        // Hashset to keep track of already considered remaining amount
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        visited.add(amount);
        queue.add(amount);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Iterate over elements in queue at current level and skip elements added in following while block
            while(size-- >= 0) {
                int current = queue.poll();
                if (current == 0) {
                    return level + 1;
                }
                for(int coin : coins) {
                    int remAmount = current - coin;
                    if (remAmount >= 0 && !visited.contains(remAmount)) {
                        visited.add(remAmount);
                        queue.add(remAmount);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    static int knapsackCoinChange(int[] coins, int index, int sum) {
        if(sum == 0) {
            return 0;
        }
        if(index == coins.length) {
            return Integer.MAX_VALUE;
        }
        int count1 = Integer.MAX_VALUE;
        if(coins[index] <= sum) {
            int res = knapsackCoinChange(coins, index, sum - coins[index]);
            if(res != Integer.MAX_VALUE) {
                count1 = res + 1;
            }
        }
        int sum2 = knapsackCoinChange(coins, index + 1, sum);
        return Math.min(count1, sum2);
    }
    
    static int dpBottomUpCoinChang(int[] coins, int sum) {
        Integer[][] dp = new Integer[coins.length][sum+1];
        for(int i=0; i < coins.length; i++)
            for(int j=0; j < sum + 1; j++)
              dp[i][j] = Integer.MAX_VALUE;
        
        for(int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }
        
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(i > 0) {
                    dp[i][j] = dp[i-1][j];
                }
                if(j >= coins[i] && dp[i][j-coins[i]] != Integer.MAX_VALUE ) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]] + 1);
                }
            }
            for(Integer[] rows : dp) {
                System.out.println(Arrays.toString(rows));
            }
        }
        return dp[coins.length - 1][sum] != Integer.MAX_VALUE ? dp[coins.length - 1][sum] : -1;
    }
}
