package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTripletSum {
    public static void main(String[] args) {
        int[] input = { -3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> triplets = new ArrayList<>();
        findTripletsDfsWithoutSorting(input, 0, 0, new ArrayList<>(), triplets);
        for(List<Integer> triplet : triplets) {
            System.out.println(Arrays.toString(triplet.toArray()));
        }
        System.out.println("*********");
        triplets = new ArrayList<>();
        findTripletsWithSortingSlidingWindow(input, triplets);
        for(List<Integer> triplet : triplets) {
            System.out.println(Arrays.toString(triplet.toArray()));
        }
        
        System.out.println("*********");
        Arrays.sort(input);
        triplets = new ArrayList<>();
        findTripletsDfsWithoutAfterSorting(input, 0, 0, new ArrayList<>(), triplets);
        findTripletsWithSortingSlidingWindow(input, triplets);
        for(List<Integer> triplet : triplets) {
            System.out.println(Arrays.toString(triplet.toArray()));
        }
    }
    
    static void findTripletsDfsWithoutSorting(int[] input, int index, int sum, List<Integer> tempList, List<List<Integer>> triplets) {
        if(sum == 0 && tempList.size() == 3) {
            triplets.add(new ArrayList<>(tempList));
            return;
        }
        if(tempList.size() == 3) {
            return;
        }
        if(index == input.length) {
            return;
        }
        tempList.add(input[index]);
        findTripletsDfsWithoutSorting(input, index + 1, sum + input[index], tempList, triplets);
        tempList.remove(tempList.size() - 1);
        findTripletsDfsWithoutSorting(input, index + 1, sum, tempList, triplets);
    }
    
    
    static void findTripletsWithSortingSlidingWindow(int[] input, List<List<Integer>> triplets) {
        Arrays.sort(input);
        for(int i = 0; i < input.length; i++) {
            if(i > 0 && input[i - 1] == input[i]) {
                continue;
            }
            findTripletsInSortedArray(input, -input[i], i+1, triplets);
        }
    }
    
    static void findTripletsInSortedArray(int[] input, int sum, int left, List<List<Integer>> triplets) {
        int right = input.length - 1;
        while(left < right) {
            int currentSum = input[left] + input[right];
            if(currentSum == sum) {
                triplets.add(Arrays.asList(-sum, input[left], input[right]));
                left++;
                right--;
                while(left < right && input[left] == input[left-1]) {
                    left++;
                }
                while(left < right && input[right] == input[right+1]) {
                    right--;
                }
            } else if(currentSum < sum) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    static void findTripletsDfsWithoutAfterSorting(int[] input, int index, int sum, List<Integer> tempList, List<List<Integer>> triplets) {
        if(sum == 0 && tempList.size() == 3) {
            triplets.add(new ArrayList<>(tempList));
            return;
        }
        if(tempList.size() == 3) {
            return;
        }
        if(index == input.length) {
            return;
        }
        for(int i = index; i < input.length; i++) {
            if(i > 0 && input[i] == input[i-1]) {
                continue;
            }
            tempList.add(input[index]);
            findTripletsDfsWithoutAfterSorting(input, i + 1, sum + input[i], tempList, triplets);
            tempList.remove(tempList.size() - 1);
        }
//        tempList.add(input[index]);
//        findTripletsDfsWithoutSorting(input, index + 1, sum + input[index], tempList, triplets);
//        tempList.remove(tempList.size() - 1);
//        findTripletsDfsWithoutSorting(input, index + 1, sum, tempList, triplets);
    }
}
