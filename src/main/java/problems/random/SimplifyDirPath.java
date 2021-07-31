package problems.random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class SimplifyDirPath {
    public static void main(String[] args) {
        Deque<String> doubleLinkedList = new LinkedList<>();
        String path = "/a//b////c/d//././/../s/";
        String[] spliettedPath = path.split("/");
        System.out.println((12 >> 32) & 1);
        char ch;
        System.out.println(Arrays.toString(spliettedPath));
        int index = 0;
        while(true) {
            if(index >= path.length()) {
                break;
            }
            StringBuffer sb = new StringBuffer();
            while(index < path.length() && (ch = path.charAt(index)) != '/') {
                sb.append(ch);
                index++;
            }
            String dir = sb.toString();
            if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if(!doubleLinkedList.isEmpty()) {
                    doubleLinkedList.removeLast();
                }
            } else if (dir.equals("")){
                index++;
            } else {
                doubleLinkedList.add(dir);
            }
        }
        StringBuffer simpliefiedPath = new StringBuffer("/");
        Iterator<String> dequeIterator = doubleLinkedList.iterator();
        while(dequeIterator.hasNext()) {
            simpliefiedPath.append(dequeIterator.next());
            if(dequeIterator.hasNext()) {
                simpliefiedPath.append("/");
            }
        }
        System.out.println(simpliefiedPath);
    }

}
