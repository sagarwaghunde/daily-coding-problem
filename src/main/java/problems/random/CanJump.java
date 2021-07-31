package problems.random;

import java.util.PriorityQueue;

public class CanJump {
    public static void main(String[] args) {
//        int[] input = {2, 3, 1, 1, 4};
        int[] input = {1,1,3,6,9,3,0,1,3};
//        int[] input = {3, 2, 1, 0, 1};
//        int[] input = {2, 0, 0};
        boolean canReachEnd = canReachEndBfs(input, 0);
        System.out.println(canReachEnd);
        System.out.println(canReachEndGreedy(input));
        System.out.println(jumpPriorityQeueue(input));
        System.out.println(dpTopDown(input, 0));
    }
    
    static boolean canReachEndBfs(int[] input, int currentIndex) {
        if(currentIndex + 1 >= input.length || (currentIndex < input.length && currentIndex + input[currentIndex] >= input.length - 1)) {
            return true;
        }
        if (currentIndex + 1 < input.length && input[currentIndex] == 0) {
            return false;
        }
        for(int value = input[currentIndex]; value > 0; value--) {
            if (canReachEndBfs(input, currentIndex + value)) {
                return true;
            }
        }
        return false;
    }
    static int dpTopDown(int[] steps, int index) {
        if(index == steps.length - 1) {
            return 0;
        }
        if(steps[index] == 0) {
            return Integer.MAX_VALUE;
        }
        int totalJumps = Integer.MAX_VALUE;
        int start = index + 1;
        int end = index + steps[index];
        while(start < steps.length && start <= end) {
            int minJumps = dpTopDown(steps, start++);
            if(minJumps != Integer.MAX_VALUE) {
                totalJumps = Math.min(totalJumps, minJumps + 1);
            }
        }
        return totalJumps;
    }
    
    static boolean canReachEndGreedy(int[] input) {
        int max = 0;
        for(int i = 0; i < input.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + input[i]);
            if (max >= input.length - 1) {
                return true;
            }
        }
        return true;
    }
    
    static public int jumpPriorityQeueue(int[] steps) {
        if(steps.length == 1) {
            return 0;
        }
        PriorityQueue<StepIndex> queue = new PriorityQueue<>();
        //Queue<StepIndex> queue = new LinkedList<>();
        boolean[] status = new boolean[steps.length];
        StepIndex firstStep = new StepIndex(0, 0, steps[0]);
        queue.add(firstStep);
        while(!queue.isEmpty()) {
            StepIndex step = queue.poll();
            int j = step.index;
            if(steps[j] == 0) {
                status[j] = true;
                continue;
            }
            for(int count = steps[j]; count >= 1; count--) {
                if(j + count >= steps.length -1) {
                    return step.count+1;
                } else if(j + count < steps.length) {
                    if(steps[j + count] != 0 && !status[j + count]) {
                        StepIndex nextStep = new StepIndex(j + count, step.count+1, j + count + steps[j + count]);
                        queue.add(nextStep);
                    }
                    status[j + count] = true;
                } else {
                    break;
                }
            }
        }
        return 0;
    }

    static class StepIndex implements Comparable<StepIndex> {
        public int index;
        public int count = 0;
        public int val;
    
        public StepIndex(int index, int count, int val) {
            this.index = index;
            this.count = count;
            this.val = val;
        }
    
        public String toString() {
            return "Index : " + index + ", Value : " + val + ", Jumps : " + count;
        }

        @Override
        public int compareTo(StepIndex o) {
            // TODO Auto-generated method stub
            if(o.val == this.val) {
                return o.index - this.index;
            }
            return o.val - this.val;
        }
    }
}
