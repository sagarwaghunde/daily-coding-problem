package problems.random;

import java.util.Arrays;

public class WinterSummer {
    public static void main(String[] args) {
//        int[] temp = {5, 2, 3, 8, 6};
//        int[] temp = {1, 2, 3, 4, 5};
//        int[] temp = {2, 1, 3, 5, 8, 7, 6, 4};
        int[] temp = {5, 2, 7, 3, 10, 9, 8};
//        int[] temp = {-2, -2, -2, 12};
        System.out.println("Temperatures : " + Arrays.toString(temp));
        System.out.println("Min winter : " + getMinimumWinter(temp));
        System.out.println("Min winter : " + solution(temp));
    }
    
    static int getMinimumWinter(int[] temp) {
        int left = 0;
        int right = temp.length - 1;
        int leftMax = temp[left];
        int rightMin = temp[right];
        if(leftMax > rightMin) {
            return right + 1;
        }
        while(left < right) {
            if(right - 1 > 0 && temp[right-1] >= leftMax) {
                right--;
                if (temp[right] < rightMin) {
                    rightMin = temp[right];
                }
            } else if(left + 1 < temp.length && temp[left] <= rightMin) {
                left++;
                if(temp[left] > leftMax) {
                    leftMax = temp[left];
                }
            }
            if(leftMax > rightMin) {
                break;
            }
        }
        return left;
    }
    
    static int solution(int[] temp) {
        int leftMax = temp[0];     //  Max temperature during winter
        int maximum = temp[0];     //  Max temperature during the year
        int position = 1;
        
        for(int i = 1; i < temp.length; i++) {
            if (temp[i] < leftMax) {
                position = i+1;      // got a new lower value
                leftMax = maximum;
            } else if (temp[i] > maximum) {
                maximum = temp[i];
            }
        }        
        return position;
    }
}
