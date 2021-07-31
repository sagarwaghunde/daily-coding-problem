package problems.range_501_525;

import java.util.stream.IntStream;

public class SortLinkedList_503 {
    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        
        sortLinkedList(root);
        ListNode node = root;
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    
    public static ListNode sortLinkedList(ListNode root) {
        int k = 2;
        ListNode first = root;
        ListNode second = root;
        for (int i = 0; i < k; i++) {
            if(second.next != null) {
                second = second.next;
            } else {
                break;
            }
        }
        return null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}