package LeetcodeProblems;

import java.util.*;

class AllOne {
    private Map<String, Node> keyNodeMap;
    private Node head, tail;
    public AllOne() {
        keyNodeMap = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("apple");
        allOne.inc("banana");
        allOne.inc("apple");
        System.out.println("Max Key: " + allOne.getMaxKey()); // Output: apple
        System.out.println("Min Key: " + allOne.getMinKey()); // Output: banana
        allOne.dec("apple");
        System.out.println("Max Key: " + allOne.getMaxKey()); // Output: apple
        System.out.println("Min Key: " + allOne.getMinKey()); // Output: apple
        allOne.dec("apple");
        System.out.println("Max Key: " + allOne.getMaxKey()); // Output: banana
        System.out.println("Min Key: " + allOne.getMinKey()); // Output: banana
    }

    public void inc(String key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.keys.remove(key);
            if (node.next.count == node.count + 1) {
                node.next.keys.add(key);
                keyNodeMap.put(key, node.next);
            } else {
                Node newNode = new Node(node.count + 1);
                newNode.keys.add(key);
                insertNodeAfter(newNode, node);
                keyNodeMap.put(key, newNode);
            }
            if (node.keys.isEmpty()) removeNode(node);
        } else {
            if (head.next.count == 1) {
                head.next.keys.add(key);
                keyNodeMap.put(key, head.next);
            } else {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                insertNodeAfter(newNode, head);
                keyNodeMap.put(key, newNode);
            }
        }
    }

    public void dec(String key) {
        Node node = keyNodeMap.get(key);
        node.keys.remove(key);
        if (node.count > 1) {
            if (node.prev.count == node.count - 1) {
                node.prev.keys.add(key);
                keyNodeMap.put(key, node.prev);
            } else {
                Node newNode = new Node(node.count - 1);
                newNode.keys.add(key);
                insertNodeAfter(newNode, node.prev);
                keyNodeMap.put(key, newNode);
            }
        } else {
            keyNodeMap.remove(key);
        }
        if (node.keys.isEmpty()) removeNode(node);
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void insertNodeAfter(Node newNode, Node prevNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }
}
