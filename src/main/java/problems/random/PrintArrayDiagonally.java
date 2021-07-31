package problems.random;

import java.util.Arrays;

public class PrintArrayDiagonally {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;
        int[][] input = {{1, 2, 3, 4}, {1, 2, 3, 4},{1, 2, 3, 4},{1, 2, 3, 4}};
        
        for(int[] arr : input) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        int startColIndex = cols - 1;
        int startRowIndex = 0;
        int i = startRowIndex;
        int j = startColIndex;
        while(true) {
            System.out.print(input[i++][j++] + " ");
            if(j == cols || i == rows) {
                j = Math.max(0, --startColIndex);
                startRowIndex = startColIndex < 0 ? startRowIndex + 1 : startRowIndex;
                i = startRowIndex;
                System.out.println();
            }
            if(startRowIndex >= rows) {
                break;
            }
        }
    }
}
