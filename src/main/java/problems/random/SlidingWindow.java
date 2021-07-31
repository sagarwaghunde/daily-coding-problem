package problems.random;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] input = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        int windowStart = 0;
        int windowSum = 0;
        for(int window = 0; window < input.length; window++) {
            windowSum += input[window];
            if(window >= k-1) {
                System.out.println((double)windowSum/k);
                windowSum -= input[windowStart];
                windowStart++;
            }
        }
    }
}
