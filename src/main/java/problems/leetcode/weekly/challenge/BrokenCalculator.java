package problems.leetcode.weekly.challenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BrokenCalculator {
    static int minOps = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        System.out.println(brokenCalc(1, 1000000000));
        System.out.println(brokenCalcEffective(2, 3));
    }
    
    public static int brokenCalc(int X, int Y) {
        System.out.println(Y);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int steps = 0;
        queue.add(X);
        visited.add(X);
        while(true) {
            int size = queue.size();
            while(size-- > 0) {
                int current = queue.poll();
                System.out.print(current + " ");
                if(current == Y) {
                    return steps;
                }
                if(current * 2 < Y * 2 && !visited.contains(current * 2)) {
                    queue.add(current * 2);
                }
                if(current > Y/2 && current - 1 > 0 && !visited.contains(current - 1)) {
                    queue.add(current - 1);
                }
            }
            steps++;
        }
    }
    
    public static int brokenCalcEffective(int X, int Y) {
        System.out.println(Y);
        int count = 0;
        while(X < Y) {
            System.out.println(Y);
            if(Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
            count++;
        }
        return count + X - Y;
    }
}
