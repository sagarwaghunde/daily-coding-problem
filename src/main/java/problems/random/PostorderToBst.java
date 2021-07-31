package problems.random;

public class PostorderToBst {
 
    public static void main(String[] args) {
        int[] input = {1, 5, 7, 10, 12, 8};
        TreeNode root = bstFromPostorder(input);
        printInorderTraversal(root);
        System.out.println();
        printPostorderTraversal(root);
    }
    static public TreeNode bstFromPostorder(int[] postorder) {
        return getBstRootNode(postorder, 0, postorder.length - 1);
    }
    
    static TreeNode getBstRootNode(int[] postorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[endIndex]);
        int index = endIndex - 1;
        while(index >= startIndex && root.val < postorder[index]) {
            index--;
        }
        root.left = getBstRootNode(postorder, startIndex, index);
        root.right = getBstRootNode(postorder, index + 1, endIndex - 1);
        return root;
    }
    
    static void printInorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        printInorderTraversal(node.left);
        System.out.print(node.val + " ");
        printInorderTraversal(node.right);
    }   
    
    static void printPostorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        printInorderTraversal(node.left);
        printInorderTraversal(node.right);
        System.out.print(node.val + " ");
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
        }
    }
}

