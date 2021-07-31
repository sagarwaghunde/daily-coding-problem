package problems.random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Staricase {
    public static void main(String[] args) {
        int[] steps = {1, 2, 3};
        int stairs = 500;
        System.out.println(totalWaysDP(stairs, new Integer[stairs + 1]));
        System.out.println(totalWaysBfs(steps, 500));
        
    }
    
    static int totalWaysBfs(int[] steps, int stairs) {
        Map<Integer, Integer> stepsByStairs = new HashMap<>();
        int totalCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(stairs);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int stairNumber = queue.poll();
                if(stepsByStairs.containsKey(stairNumber)) {
                    totalCount += stepsByStairs.get(stairNumber);
                    stepsByStairs.put(stairNumber, totalCount);
                    continue;
                }
                for(int step : steps) {
                    if(step == stairNumber) {
                        totalCount++;
                        stepsByStairs.put(stairNumber, totalCount);
                    } else if (step < stairNumber) {
                        queue.add(stairNumber - step);
                    }
                }
            }
        }
        return totalCount;
    }
    
    static int totalWaysBfsBottomUp(int[] steps, int stairs) {
        Map<Integer, Integer> stepsByStairs = new HashMap<>();
        int totalCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(stairs);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int stairNumber = queue.poll();
                if(stepsByStairs.containsKey(stairNumber)) {
                    totalCount += stepsByStairs.get(stairNumber);
                    stepsByStairs.put(stairNumber, totalCount);
                    continue;
                }
                for(int step : steps) {
                    if(step == stairNumber) {
                        totalCount++;
                        stepsByStairs.put(stairNumber, totalCount);
                    } else if (step < stairNumber) {
                        queue.add(stairNumber - step);
                    }
                }
            }
        }
        return totalCount;
    }
    
    static int totalWaysDP(int stairs, Integer[] dp) {
        if(stairs == 0 || stairs == 1) {
            return 1;
        }
        if(stairs == 2) {
            return 1;
        }
        if(dp[stairs] == null) {
            int totalWaysWith1Step = totalWaysDP(stairs - 1, dp);
            int totalWaysWith2Step = totalWaysDP(stairs - 2, dp);
            int totalWaysWith3Step = totalWaysDP(stairs - 3, dp);
            dp[stairs] = totalWaysWith1Step + totalWaysWith2Step + totalWaysWith3Step;
        }
        return dp[stairs];
    }
}
