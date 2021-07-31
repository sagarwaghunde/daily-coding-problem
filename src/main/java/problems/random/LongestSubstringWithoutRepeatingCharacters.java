package problems.random;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(lengthOfLongestSubstring("abba"));
    }
    
    static public int lengthOfLongestSubstring(String s) {
        int substringStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charactersByIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(charactersByIndex.containsKey(s.charAt(i)) && charactersByIndex.get(s.charAt(i)) >= substringStart) {
                maxLength = Math.max(maxLength, i - substringStart);
                substringStart = charactersByIndex.get(s.charAt(i)) + 1;
            }
            charactersByIndex.put(s.charAt(i), i);
        }
        return Math.max(maxLength, s.length() - substringStart);
    }

}
