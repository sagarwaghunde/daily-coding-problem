package problems.random;

public class FindUniqueElementInArrayOfTwoDuplicates {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {2, 4, 5, 6, 7, 2, 5, 6, 7, 1, 1};
        
        int result = 0;
        for(int i = 0; i < input.length; i++) {
            result ^= input[i];
        }
        
        System.out.println(result);
        System.out.println(0 ^ 0);
        int bit = 4 >> 10 & 1;
        System.out.println(bit);
    }

}
