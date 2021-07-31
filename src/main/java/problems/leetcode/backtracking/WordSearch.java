package problems.leetcode.backtracking;

import java.util.Map;

public class WordSearch {

    public static void main(String[] args) {
        String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        String word = "SEE";
        System.out.println(doesWordExist(board, word));
    }
    
    static boolean doesWordExist(String[][] board, String word) {
        boolean[][] traversal = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, traversal, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean helper(String[][] board, boolean[][] traversal, String word, int row, int col, int wordIndex) {
        if(wordIndex == word.length()) {
            return true;
        }
        if(row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return false;
        }
        if(board[row][col].charAt(0) == word.charAt(wordIndex) && !traversal[row][col]) {
            traversal[row][col] = true;
            boolean res = helper(board, traversal, word, row + 1, col, wordIndex + 1) ||
                            helper(board, traversal, word, row, col + 1, wordIndex + 1) ||
                            helper(board, traversal, word, row - 1, col, wordIndex + 1) ||
                            helper(board, traversal, word, row, col - 1, wordIndex + 1);
            traversal[row][col] = false;
            return res;
        } 
        return false;
        
    }

}
