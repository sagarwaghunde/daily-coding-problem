package problems.random;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DuplicateElementsInArray {
    public static void main(String[] args) {
        int[] input = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(input));
        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new LinkedList<>();
        Set<Character> openingBrackets = new HashSet<>(Arrays.asList('{','<','(','['));    

    }
    
    public static  int findDuplicate(int[] numbers) {
        int floor = 1;
        int ceiling = numbers.length - 1;

        while (floor < ceiling) {

            // divide our range 1..n into an upper range and lower range
            // (such that they don't overlap)
            // lower range is floor..midpoint
            // upper range is midpoint+1..ceiling
            int midpoint = floor + ((ceiling - floor) / 2);
            int lowerRangeFloor = floor;
            int lowerRangeCeiling = midpoint;
            int upperRangeFloor = midpoint + 1;
            int upperRangeCeiling = ceiling;

            // count number of items in lower range
            int itemsInLowerRange = 0;
            for (int item : numbers) {

                // is it in the lower range?
                if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
                    itemsInLowerRange += 1;
                }
            }

            int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

            if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {

                // there must be a duplicate in the lower range
                // so use the same approach iteratively on that range
                floor = lowerRangeFloor;
                ceiling = lowerRangeCeiling;
            } else {

                // there must be a duplicate in the upper range
                // so use the same approach iteratively on that range
                floor = upperRangeFloor;
                ceiling = upperRangeCeiling;
            }
        }

        // floor and ceiling have converged
        // we found a number that repeats!
        return floor;
    }
}