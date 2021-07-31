package problems.leetcode.daily.challenge;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class HackerRank {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 15;
        IntStream.range(1, n + 1).mapToObj(i -> i % 3 == 0 ? i % 5 == 0 ? "FizzBuzz" : "Fiz" : i % 5 == 0 ? "Buzz" : String.valueOf(i)).forEach(System.out::println);
    }
    
}
