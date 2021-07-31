package problems.range_475_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wordbreak_480 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello world");
        
//        String[] words = {"quick","brown","the", "fox"};
//        String input = "thequickbrownfox";
//        List<List<String>> outputs = breakInputByWords(words, input);
//        for(List<String> output : outputs) {
//            for(String value : output) {
//                System.out.print(value + ", ");
//            }
//            System.out.println();
//        }
        
//        System.out.println("Set - 2");
        String[] words = new String[]{"bed","bath","bedbath", "beyond", "and"};
        String input = "bedbathandbeyond";
//        List<List<String>> outputs1 = breakInputByWords(words, input);
//        for(List<String> output : outputs1) {
//            for(String value : output) {
//                System.out.print(value + ", ");
//            }
//            System.out.println();
//        }
        
        System.out.println("Prefix method");
        List<String> output = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for(String word : words) {
            dict.add(word);
        }
        breakInput(dict, input, output);
        for(String value : output) {
            System.out.print(value + " ");
        }
        List<List<String>> outputs = new ArrayList<>();
        System.out.println("\nWord Break Util : ");
        workBreakUtil(dict, input, "");
//        workBreakUtil(dict, input, outputs);
        for(List<String> output1 : outputs) {
          for(String value : output1) {
              System.out.print(value + ", ");
          }
          System.out.println();
        }
        
    }

    static void breakInput(Set<String> dict, String input, List<String> output) {
        int index = 0;
        while(input.length() > 0) {
            String prefix = input.substring(0, index);
            if(dict.contains(prefix)) {
                output.add(prefix);
                input = input.substring(index);
                index = 0;
            } else {
                index++;
            }
        }
    }
    
    static void workBreakUtil(Set<String> dict, String input, String result) {
        for(int i = 1; i <= input.length(); i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == input.length()) {
                    result = result + " " + prefix;
                    System.out.println(result);
                    return;
                }
                workBreakUtil(dict, input.substring(i), result + " " + prefix);
            }
        }
    }
    
    static void workBreakUtil(Set<String> dict, String input, List<List<String>> outputs) {
        List<String> output = new ArrayList<>();
        for(int i = 1; i <= input.length(); i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == input.length()) {
                    output.add(prefix);
                    outputs.add(output);
                    output = new ArrayList<>();
                    return;
                }
                output.add(prefix);
                workBreakUtil(dict, input.substring(i), outputs);
            }
        }
    }
    
    
}
