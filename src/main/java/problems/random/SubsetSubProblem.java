package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSubProblem {
    public static void main(String[] args) {
//        int[] elements = {2, 2, 3, 3, 4, 5, 6, 6, 8, 10};
        int[] elements = {2, 3, 4, 5, 6, 8, 10};
        boolean[] used = new boolean[elements.length];
        int sum = 10;
        List<List<Integer>> results = new ArrayList<>();
        getCombinations(elements, 0, used, sum, new ArrayList<>(), new ArrayList<>());
        //getCombinationsByDfs(elements, sum, new ArrayList<>(), 0);
//        getSubsetWithGivenSum(elements, sum, 0, new ArrayList<>(), results);
        for(List<Integer> result : results) {
            for(int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    static void getCombinations(int[] elements, int index, boolean[] used, int remainingSum, List<Integer> currentList, List<List<Integer>> result) {
        if(remainingSum < 0) {
            return;
        }
        if(remainingSum == 0) {
            result.add(currentList);
            System.out.println(Arrays.toString(currentList.toArray()));
            return;
        }
        for(int i = index; i < elements.length; i++) {
//            if(used[i]) {
//                continue;
//            }
//            if(i > 0 && elements[i] == elements[i-1]) {
//                continue;
//            }
            currentList.add(elements[i]);
            used[i] = true;
            getCombinations(elements, i + 1, used, remainingSum - elements[i], currentList, result);
            used[i] = false;
            currentList.remove(currentList.size() - 1);
        }
    }
    
    static void getCombinationsByDfs(int[] elements, int remainingSum, List<Integer> currentList, int elementIndex) {
        if(remainingSum < 0) {
            System.out.println("Wrong : " + Arrays.toString(currentList.toArray()));
            return;
        }
        if(remainingSum == 0) {
            System.out.println("result : " + Arrays.toString(currentList.toArray()));
            return;
        }
        if(elementIndex >= elements.length) {
            System.out.println("Wrong : " + Arrays.toString(currentList.toArray()));
            return;
        }
        currentList.add(elements[elementIndex]);
        getCombinationsByDfs(elements, remainingSum - elements[elementIndex], currentList, elementIndex+1);
        currentList.remove(currentList.size() - 1);
        getCombinationsByDfs(elements, remainingSum, currentList, elementIndex+1);
    }
    
    static void getSubsetWithGivenSum(int[] elements, int sum, int index, List<Integer> tempIndex, 
            List<List<Integer>> result) {
        if(sum == 0) {
            result.add(new ArrayList<>(tempIndex));
            return;
        } else if (sum < 0) {
            return;
        }
        if(index == elements.length) {
            return;
        }
        tempIndex.add(elements[index]);
        getSubsetWithGivenSum(elements, sum - elements[index], index + 1, tempIndex, result);
        tempIndex.remove(tempIndex.size() - 1);
        getSubsetWithGivenSum(elements, sum, index + 1, tempIndex, result);
    }
}
