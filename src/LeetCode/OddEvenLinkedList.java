package LeetcodeProblems;

/**
 * Definition for singly-linked list.
 */
class ListNodes {
    int val;
    listnode next;
    ListNodes() {}
    ListNodes(int val) { this.val = val; }
    ListNodes(int val, listnode next) { this.val = val; this.next = next; }
}

public class OddEvenLinkedList {
    // Helper method to create a linked list from an array
    public static listnode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        listnode head = new listnode(arr[0]);
        listnode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new listnode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list
    public static void printLinkedList(listnode head) {
        listnode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        int[] arr = {1, 2, 3, 4, 5};
        listnode head = createLinkedList(arr);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Create an instance of OddEvenLinkedList
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // Apply odd-even grouping
        listnode result = solution.oddEvenList(head);

        System.out.println("Linked List after odd-even grouping:");
        printLinkedList(result);
    }

    public listnode oddEvenList(listnode head) {
        // Handle edge cases
        if (head == null || head.next == null) {
            return head;
        }

        listnode odd = head;
        listnode even = head.next;
        listnode evenHead = even;

        while (even != null && even.next != null) {
            // Connect odd nodes
            odd.next = even.next;
            odd = odd.next;

            // Connect even nodes
            even.next = odd.next;
            even = even.next;
        }

        // Connect the end of odd list to the start of even list
        odd.next = evenHead;

        return head;
    }
}