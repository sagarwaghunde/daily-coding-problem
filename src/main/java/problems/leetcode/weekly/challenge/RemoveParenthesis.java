package problems.leetcode.weekly.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RemoveParenthesis {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "))sagar(())";
        System.out.println(minRemoveToMakeValid(input));
    }
    
    static String minRemoveToMakeValidOld(String s) {
        Set<Integer> removeIndices = new HashSet<>();
        Stack<Integer> openIndices = new Stack<>();
        AtomicInteger index = new AtomicInteger();
        s.chars().map(c -> (char)c).forEach(c -> {
            if(c == '(') {
                openIndices.push(index.get());
            } else if (c == ')') {
                if(openIndices.isEmpty()) {
                    removeIndices.add(index.get());
                } else {
                    openIndices.pop();
                }
            }
            index.getAndIncrement();
        });
        removeIndices.addAll(openIndices);
        StringBuffer result = new StringBuffer();
        IntStream.range(0, s.length()).filter(i -> !removeIndices.contains(i)).forEach(i -> result.append(s.charAt(i)));
        return result.toString();
    }
    
    static String minRemoveToMakeValid(String s) {
        int[] stack = new int[s.length()];
        Arrays.fill(stack, -1);
        char[] ans = s.toCharArray();
        int stackIndex = -1;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack[++stackIndex] = i;
            } else if (s.charAt(i) == ')') {
                if(stackIndex >= 0) {
                    stack[stackIndex] = -1;
                    stackIndex--;
                } else {
                    ans[i] = '_';
                }
            }
        }
        System.out.println(Arrays.toString(stack));
        stackIndex = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(j == stack[stackIndex]) {
                stackIndex++;
            } else if(ans[j] != '_') {
                ans[i++] = ans[j];
            }
        }
        return new String(ans, 0, i);
    }
}
