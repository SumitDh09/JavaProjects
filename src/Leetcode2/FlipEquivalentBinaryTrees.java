package Leetcode2;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        // Check if trees are equivalent without flipping
        boolean isSame = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        if (isSame) {
            return true;
        }

        // Check if trees are equivalent after flipping
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }

    public static void main(String[] args) {
        // Create test trees
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))),
                new TreeNode(3, new TreeNode(6), null)
        );

        TreeNode root2 = new TreeNode(1,
                new TreeNode(3, null, new TreeNode(6)),
                new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(7)))
        );

        FlipEquivalentBinaryTrees solution = new FlipEquivalentBinaryTrees();
        boolean result = solution.flipEquiv(root1, root2);

        System.out.println("Are the trees flip equivalent? " + result);
    }
}