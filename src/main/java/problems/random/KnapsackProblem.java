package problems.random;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weights = { 2, 3, 1, 4 };
        int[] profits = { 4, 5, 3, 7 };
        int capacity = 5;
        boolean[] used = new boolean[weights.length];
        int profit = getMaximumProfit(weights, profits, capacity, used);
        System.out.println(profit);
    }
    
    static int getMaximumProfit(int[] weights, int[] profits, int capacity, boolean[] used) {
        if(capacity <= 0) {
            return 0;
        }
        int profit1 = 0;
        int profit2 = 0;
        for(int i = 0; i < weights.length; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            profit1 = profits[i] + getMaximumProfit(weights, profits, capacity - weights[i], used);
            used[i] = false;
        }
        return Math.max(profit1, profit2);
    }
}
