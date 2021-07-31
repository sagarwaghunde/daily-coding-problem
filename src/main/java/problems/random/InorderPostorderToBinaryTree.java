package problems.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import static java.util.stream.Collectors.toMap;
import java.util.stream.IntStream;

/**
       13
     /    \
    2      3
   / \    /
  5   6  7
        / \
       8   9
            \
            10
            /
          12
 * @author sagar.waghunde
 *
 */
public class InorderPostorderToBinaryTree {
    public static void main(String[] args) {
        int[] inOrder = {5,  2,  6,  13,  8,  7,  9,  12,  10,  3};
        int[] postOrder = {5,  6,  2,  8,  12,  10,  9,  7,  3,  13};
        
        TreeNode root = buildTree(inOrder, postOrder);
//        System.out.println("Inorder : ");
//        printInorderTraversal(root);
//        System.out.println("\nPreorder : ");
//        printPreorderTraversal(root);
        System.out.println("\nEuler : ");
        printEulerianPath(root);
    }
    
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> indexByValues = IntStream.range(0, inorder.length).boxed()
                .collect(toMap(i -> inorder[i], Function.identity()));
        return buildTree(inorder, postorder, indexByValues, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    static TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> indexByValues,
                                int inorderStartIndex, int inorderEndIndex,
                                int postOrderStartIndex, int postOrderEndIndex) {
        if (postOrderStartIndex > postOrderEndIndex || inorderStartIndex > inorderEndIndex) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postOrderEndIndex]);
        int rootNodeIndex = indexByValues.get(postorder[postOrderEndIndex]);
        node.left = buildTree(inorder, postorder, indexByValues,
                                inorderStartIndex, rootNodeIndex - 1,
                                postOrderStartIndex,
                                postOrderStartIndex + rootNodeIndex - inorderStartIndex - 1);
        node.right = buildTree(inorder, postorder, indexByValues,
                                rootNodeIndex + 1, inorderEndIndex, 
                                postOrderStartIndex + rootNodeIndex - inorderStartIndex,
                                postOrderEndIndex - 1);
        return node;
    }
    
    static void printInorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printInorderTraversal(node.left);
        System.out.print(node.value + " ");
        printInorderTraversal(node.right);
        System.out.print(node.value + " ");
    }
    
    static void printPreorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printInorderTraversal(node.left);
        printInorderTraversal(node.right);
    }
    static void printEulerianPath(TreeNode node) {
        if(node.left == null && node.right == null) {
            System.out.print(node.value + " ");
            return;
        }
        System.out.print(node.value + " ");
        if(node.left != null) {
            printEulerianPath(node.left);
            System.out.print(node.value + " ");
        }
        if(node.right != null) {
            printEulerianPath(node.right);
            System.out.print(node.value + " ");
        }
        
    }
    
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int value) {
        this.value = value;
    }
}