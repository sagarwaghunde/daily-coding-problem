package problems.random;

public class RemoveKthElementFromLast {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node = root;
        for(int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        printList(root);
        System.out.println("\nAfter : ");
        printList(removeNthFromEnd(root, 5));
    }
    
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        for(int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        ListNode kthNode = start;
        while(fast != null) {
            kthNode = kthNode.next;
            fast = fast.next;
        }
        kthNode.next = kthNode.next.next;
        return start.next;
    }
    
    static void printList(ListNode root) {
        ListNode current = root;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}
