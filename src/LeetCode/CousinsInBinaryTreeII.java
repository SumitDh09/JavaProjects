package LeetcodeProblems;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class treenode {
    int val;
    treenode left;
    treenode right;
    treenode() {}
    treenode(int val) { this.val = val; }
    treenode(int val, treenode left, treenode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CousinsInBinaryTreeII {
    public static void main(String[] args) {
        // Example usage
        treenode root = new treenode(5, new treenode(4, new treenode(1), new treenode(10)), new treenode(9, null, new treenode(7)));
        CousinsInBinaryTreeII solution = new CousinsInBinaryTreeII();
        treenode newRoot = solution.replaceValueInTree(root);
        printTree(newRoot);
    }

    // Helper method to print the tree
    public static void printTree(treenode root) {
        if (root == null) return;
        Queue<treenode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            treenode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public treenode replaceValueInTree(treenode root) {
        // bfs
        Queue<treenode> queue = new LinkedList<>();
        queue.offer(root);
        int prevSum = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int curSum = 0;
            for (int i = 0; i < size; i++) {
                treenode node = queue.poll();
                node.val = prevSum - node.val;
                int sibsum = 0;
                if (node.left != null) {
                    sibsum += node.left.val;
                }
                if (node.right != null) {
                    sibsum += node.right.val;
                }
                if (node.left != null) {
                    curSum += node.left.val;
                    node.left.val = sibsum;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    curSum += node.right.val;
                    node.right.val = sibsum;
                    queue.offer(node.right);
                }
            }
            prevSum = curSum;
        }
        return root;
    }
}
