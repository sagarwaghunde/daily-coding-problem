package problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        String input = "25525511135";
        List<String> result = restoreIpAddress(input);
        for(String ipAddress : result) {
            System.out.println(ipAddress);
        }
        
    }
    
    static List<String> restoreIpAddress(String input) {
        List<String> result = new ArrayList<>();
//        helperIterator(input, 0, "", result, 0);
        helper(input, 0, "", result, 0);
//        helperRecursive(input, 0, "", result, 3);
//        helper(input, 0, new StringBuilder(), result, 0);
        return result;
    }
    
    static void helperIterator(String input, int index, String soFar, List<String> result, int count) {
        if(count > 4) {
            return;
        }
        if(index == input.length() && count == 4) {
            result.add(soFar);
            return;
        }
        for(int i = 1; i <=3; i++) {
            if(index + i > input.length()) {
                break;
            }
            if((input.length() - index) > (4 - count) * 3) {
                break;
            }
            String octet = input.substring(index, index + i);
            if((octet.length() > 1 && octet.charAt(0) == '0') || i == 3 && Integer.parseInt(octet) > 255) {
                continue;
            }
            
            helperIterator(input, index + i, soFar + octet + (count == 3 ? "" : "."), result, count+1);
        }
    }
    
    static void helper(String input, int index, String soFar, List<String> result, int count) {
        if(index == input.length() && count == 3 && soFar.lastIndexOf('.') != soFar.length() - 1) {
            result.add(soFar);
            return;
        }
        if(count > 4) {
            return;
        }
        if(index >= input.length()) {
            return;
        }
        soFar = soFar + (input.charAt(index));
        String octet = soFar.substring(soFar.lastIndexOf(".") + 1);
        if(Integer.parseInt(octet) > 255) {
            return;
        }
        if(octet.charAt(0) == '0' && octet.length() > 1) {
            return;
        }
        helper(input, index + 1, soFar, result, count);
        helper(input, index + 1, soFar  + ".", result, count+1);
    }
    
    static void helperRecursive(String input, int index, String soFar, List<String> result, int count) {
        if(index == input.length() && count == 0 && soFar.lastIndexOf('.') != soFar.length() - 1) {
            result.add(soFar);
            return;
        } else if (count < 0 || index >= input.length()) {
            return;
        }
        if(index + count < input.length() - 1) {
            return;
        }
        soFar = soFar + (input.charAt(index));
        String octet = soFar.substring(soFar.lastIndexOf(".") + 1);
        if(Integer.parseInt(octet) > 255) {
            return;
        }
        if(octet.charAt(0) == '0' && octet.length() > 1) {
            return;
        }
        helperRecursive(input, index + 1, soFar, result, count);
        helperRecursive(input, index + 1, soFar  + ".", result, count-1);
    }
} 
