
package LeetcodeProblems;

public class mergenode {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode node = head;
        while (node != null) {
            int sum = 0;
            ListNode temp = node;
            while (temp != null) {
                sum += temp.val;
                temp = temp.next;
            }
            node.val = sum;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode merged = mergeNodes(node1);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
