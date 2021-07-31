package problems.random;

public class PreorderToBst {
 
    public static void main(String[] args) {
        int[] input = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(input);
        printInorderTraversal(root);
        System.out.println();
        printPostorderTraversal(root);
    }
    static public TreeNode bstFromPreorder(int[] preorder) {
        return getBstRootNode(preorder, 0, preorder.length - 1);
    }
    
    static TreeNode getBstRootNode(int[] preorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startIndex]);
        int index = startIndex + 1;
        while(index <= endIndex && root.val > preorder[index]) {
            index++;
        }
        root.left = getBstRootNode(preorder, startIndex + 1, index - 1);
        root.right = getBstRootNode(preorder, index, endIndex);
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

