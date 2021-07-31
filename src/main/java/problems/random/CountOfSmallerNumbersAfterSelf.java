package problems.random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        int[] input =  {5, 6, 2, 6, 1};
        int[] result = getSmallerNumbersAfterSelfByBinaryTree(input);
        System.out.println(Arrays.toString(result));
        getSmallerNumbersAfterSelfByMergeSort(input);
    }
    
    static int[] getSmallerNumbersAfterSelfByBinaryTree(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }
        int[] result = new int[input.length];
        TreeNode root = null;
        for(int i = input.length - 1; i >= 0; i--) {
            root = insertIntoBinarySearchTree(root, input[i], result, i, 0);
        }
        return result;
    }
    
    static TreeNode insertIntoBinarySearchTree(TreeNode root, int value, int[] result, int index, int sum) {
        if (root == null) {
            TreeNode node = new TreeNode(value, 0);
            result[index] = sum;
            return node;
        }
        if (value < root.value) {
            root.lessThan++;
            root.left = insertIntoBinarySearchTree(root.left, value, result, index, sum);
        } else {
            if (value != root.value) {
                root.right = insertIntoBinarySearchTree(root.right, value, result, index, sum + root.lessThan + 1);
            } else {
                root.right = insertIntoBinarySearchTree(root.right, value, result, index, sum + root.lessThan);
            }
        }
        return root;
    }
    
    static class TreeNode {
        int value;
        int lessThan = 0;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value, int lessThan) {
            this.value = value;
            this.lessThan = lessThan;
        }
    }
    
    static void getSmallerNumbersAfterSelfByMergeSort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        int[] smallestAfter = new int[input.length];
        Pair[] pairs = new Pair[input.length];
        for(int i = 0; i < input.length; i++) {
            pairs[i] = new Pair(i, input[i]);
        }
        mergeSort(pairs, smallestAfter);
        System.out.println(Arrays.toString(smallestAfter));
    }
    
    static Pair[] mergeSort(Pair[] arr, int[] smallest) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Pair[] leftPairs = mergeSort(Arrays.copyOfRange(arr, 0, mid), smallest);
        Pair[] rightPairs = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smallest);
        for(int i = 0, j = 0; i < leftPairs.length || j < rightPairs.length; ) {
            if (j == rightPairs.length || i < leftPairs.length && leftPairs[i].value <= rightPairs[j].value) {
                arr[i + j] = leftPairs[i];
                smallest[leftPairs[i].index] += j;
                i++;
            } else {
                arr[i + j] = rightPairs[j];
                j++;
                
            }
        }
        return arr;
        
    }
    static class Pair {
        int value;
        int index;
        
        public Pair(int index, int value) {
            this.value = value;
            this.index = index;
        }
        
        public String toString() {
            return "[" + index + ":" + value + "]";
        }
    }
}
