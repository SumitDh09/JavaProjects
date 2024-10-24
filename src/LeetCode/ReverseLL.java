package LeetcodeProblems;

class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
}

class ReverseLL {
    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Printing the original list
        System.out.print("Original List: ");
        printList(head);

        // Reversing the list
        ReverseLL solution = new ReverseLL();
        Node reversedHead = solution.reverseList(head);

        // Printing the reversed list
        System.out.print("Reversed List: ");
        printList(reversedHead);
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
