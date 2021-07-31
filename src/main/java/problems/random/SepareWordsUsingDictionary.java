package problems.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SepareWordsUsingDictionary {
    static Set<String> dictionary;
    static int count;
    public static void main(String[] args) {
        dictionary = new HashSet<>(Arrays.asList(new String[]{"wha","what", "is", "java", "whatis"}));
        
        System.out.println(Arrays.toString("the cattle was rattled by the battery".split("\\s+")));
        String input = "whatisjava";
        Map<Integer, Integer> map;
        List<List<String>> results = new ArrayList<>();
        getMatchingPatterns(input, 0, new ArrayList<>(), results);
        for(List<String> result : results ) {
            for(String word : result) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
        System.out.println(count);
    }
    
    static void getMatchingPatterns(String input, int index, List<String> tempPattern,
            List<List<String>> result) {
        if(index == input.length()) {
            return;
        }
        StringBuffer wordSb = new StringBuffer();
        for(int i = index; i < input.length(); i++) {
            wordSb.append(input.charAt(i));
            if(dictionary.contains(wordSb.toString())) {
                tempPattern.add(wordSb.toString());
                if(i+1 == input.length()) {
                    result.add(new ArrayList<>(tempPattern));
                } else {
                    getMatchingPatterns(input, i+1, tempPattern, result);
                }
                tempPattern.remove(tempPattern.size() - 1);
            }
        }
    }
    
}
//    static void getMatchingPatterns(String input, List<String> tempPattern,
//            List<List<String>> result) {
//        for(int i = 0; i < input.length(); i++) {
//            String word = input.substring(0, i + 1);
//            if(dictionary.contains(word)) {
//                tempPattern.add(word);
//                if(i+1 == input.length()) {
//                    result.add(new ArrayList<>(tempPattern));
//                } else {
//                    getMatchingPatterns(input.substring(i + 1), tempPattern, result);
//                }
//                tempPattern.remove(tempPattern.size() - 1);
//            }
//        }
//    }
    
