package problems.random;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        
        System.out.println(kthSmallet(new int[] { 5, 12, 11, -1, 12 }, 3));
    }
    static int kthSmallet(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
