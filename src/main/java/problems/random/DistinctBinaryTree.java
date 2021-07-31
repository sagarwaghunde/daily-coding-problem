 package problems.random;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DistinctBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        root.left = two;
        root.right = three;
        
        Node four = new Node(4);
        Node five = new Node(2);
        Node six = new Node(6);
        Node three_1 = new Node(10);
        Node seven = new Node(7);
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = three_1;
        
        Node two_1 = new Node(2);
        Node eight = new Node(4);
        four.left = two_1;
        four.right = eight;
        
        Node nine = new Node(9);
        Node one_1 = new Node(1);
        five.left = nine;
        five.right = one_1;
        
        nine.left = new Node(100);
        nine.right = new Node(101);
        
        one_1.left = new Node(200);
        one_1.right = new Node(201);
        
        three_1.left = new Node(11);
        three_1.right = new Node(12);
        System.out.print("In order : ");
        preOrder(root);
        System.out.print("\nPrint distinct, pre Order : ");
        printDistinctTreePreOrder(root, new HashSet<>());
        
        System.out.print("\nPrint distinct, pre Order, with length : ");
        int length = printDistinctTreePreOrderWithLongestTree(root, new HashSet<>());
        System.out.println("\nLength : " + length);
        
        System.out.print("\nPrint distinct, BFS : ");
        printDistinctTreeQueue(root);
    }
    
    static void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    static void printDistinctTreePreOrder(Node node, Set<Integer> visitedValues) {
        if(node != null && !visitedValues.contains(node.value)) {
            System.out.print(node.value + " ");
            visitedValues.add(node.value);
            printDistinctTreePreOrder(node.left, visitedValues);
            printDistinctTreePreOrder(node.right, visitedValues);
        }
    }
    
    static int printDistinctTreePreOrderWithLongestTree(Node node, Set<Integer> visitedValues) {
        if(node != null && !visitedValues.contains(node.value)) {
            System.out.print(node.value + " ");
            visitedValues.add(node.value);
            return Math.max(1 + printDistinctTreePreOrderWithLongestTree(node.left, visitedValues),
                            1 + printDistinctTreePreOrderWithLongestTree(node.right, visitedValues));
        } else {
            return -1;
        }
    }
    
    static void printDistinctTreeQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Deque<Node> deque =  new LinkedList<>();
        queue.add(root);
        Set<Integer> visitedValues = new HashSet<>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visitedValues.add(node.value);
            System.out.print(node.value + " ");
            Node left = node.left;
            if(left != null && !visitedValues.contains(left.value)) {
                queue.add(left);
            }
            Node right = node.right;
            if(right != null && !visitedValues.contains(right.value)) {
                queue.add(right);
            }
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value) {
        this.value = value;
    }
}
