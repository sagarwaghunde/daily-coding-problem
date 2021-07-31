package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
        //int[] input = {0, 1, 2, 3, 4, 5, 6};
        int[] input = {-1, -100, 3, 99};
        int k = 2;
        System.out.println("Before rotation : " + Arrays.toString(input));
//        for (int i = 0; i < k; i++) {
//            rotateArrayByOnePosition(input);
//        }
//        rotateArrayNPositions(input, k);
        rotateByNPositions(input, k);
        System.out.println("After rotation : " + Arrays.toString(input));
        getException(15);
        List list = new ArrayList();
        list.add("hi");
        list.add(1);
        System.out.println(list.get(0) instanceof Object);
        System.out.println(list.get(1) instanceof Integer);
    }
    
    static Exception getException ( int i) {
        if (i > 10) {
            return new Exception(
                    "e");
        } else {
            throw new RuntimeException("RE");
        }
    }
    static void rotateArrayByOnePosition(int[] input) {
        int length = input.length;
        int prev = input[(length-1) % length];
        for (int i = 0; i < length; i++) {
            int current = input[i];
            input[i] = prev;
            prev = current;
        }
    }
    
    static void rotateArrayNPositions(int[] input, int k) {
        int[] temp = new int[input.length - k];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = input[i];
        }
        int i = 0;
        for(; i < k; i++) {
            int index = (i + input.length - k) % input.length;
            input[i] = input[index];
        }
        int tempIndex = 0;
        for(; i < input.length; i++) {
            input[i] = temp[tempIndex++];
        }
    }
    
    static void rotateByNPositions(int[] input, int k) {
        k %= input.length;
        if (k == 0) {
            return;
        }
        int count = 0;
        int length = input.length;
        for (int start = 0; count < input.length; start++) {
            int currentIndex = start;
            int prev = input[start];
            do {
                int nextIndex = (currentIndex + k) % length;
                int temp = input[nextIndex];
                input[nextIndex] = prev;
                prev = temp;
                currentIndex = nextIndex;
                count++;
            } while (currentIndex != start);
        }
        
/**
 *      k %= input.length;
        if (k == 0) {
            return;
        }
        int length = input.length;
        int prev = input[length - k];
        int index = 0;
        int count = length;
        while ( count-- >= 0) {
            int current = input[index];
            input[index] = prev;
            prev = current;
            index = (index + k) % length;
        }
 */
    }
}
