package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = permute(nums);
    }
    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(nums, list, new ArrayList<>(), new boolean[nums.length]);
        return list;
    }
    
    static void permute(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            System.out.println(Arrays.toString(currResult.toArray()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            currResult.add(nums[i]);
            used[i] = true;
            permute(nums, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
            
        }
    }
}
