package problems.random;

import java.util.Arrays;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int target = 1;
        int totalSum = Arrays.stream(nums).sum();
        Map<String, String> map;
        System.out.println(getTargetSumCombinations(nums, 0, target, totalSum, 0, 0));
    }
    
    static int getTargetSumCombinations(int[] nums, int index, int target, int totalSum, int s1, int s2) {
        if(s1 + s2 == totalSum && s1 - s2 == target) {
            return 1;
        }
        if(nums.length == index) {
            return 0;
        }
        return getTargetSumCombinations(nums, index + 1, target, totalSum, s1 + nums[index], s2) +
                getTargetSumCombinations(nums, index + 1, target, totalSum, s1, s2 + nums[index]);
    }
}
