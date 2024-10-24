package LeetcodeProblems;

/**
 * Definition for singly-linked list.
 * public class listnode {
 *     int val;
 *     listnode next;
 *     listnode() {}
 *     listnode(int val) { this.val = val; }
 *     listnode(int val, listnode next) { this.val = val; this.next = next; }
 * }
 */
class DeleteTheMiddleNode {
        public static void main(String[] args) {
            DeleteTheMiddleNode solution = new DeleteTheMiddleNode();
            int[][] testCases = {{1, 3, 4, 7, 1, 2, 6}, {1, 2, 3, 4}, {2, 1}, {1}};

            for (int i = 0; i < testCases.length; i++) {
                listnode head = createLinkedList(testCases[i]);
                System.out.println("Test case " + (i + 1) + " - Before: " + listToString(head));
                head = solution.deleteMiddle(head);
                System.out.println("Test case " + (i + 1) + " - After:  " + listToString(head) + "\n");
            }
        }

        private static listnode createLinkedList(int[] arr) {
            listnode dummy = new listnode(0);
            listnode current = dummy;
            for (int val : arr) {
                current.next = new listnode(val);
                current = current.next;
            }
            return dummy.next;
        }

        private static String listToString(listnode head) {
            StringBuilder sb = new StringBuilder();
            while (head != null) {
                sb.append(head.val).append(" ");
                head = head.next;
            }
            return sb.toString().trim();
        }

    public listnode deleteMiddle(listnode head) {
            if (head == null || head.next == null) return null;

            listnode slow = head, fast = head, prev = null;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }
            prev.next = slow.next;
            return head;
        }
    }
class listnode {
    int val;
    listnode next;

    listnode(int val) {
        this.val = val;
    }
}

