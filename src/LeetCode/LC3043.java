package LeetcodeProblems;

class TrieNode {
    public TrieNode[] children = new TrieNode[10];
}

class Trie {
    private TrieNode root = new TrieNode();

    public void insert(final String word) {
        TrieNode node = root;
        for (final char c : word.toCharArray()) {
            final int i = c - '0';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
    }

    public int search(final String word) {
        int prefixLength = 0;
        TrieNode node = root;
        for (final char c : word.toCharArray()) {
            final int i = c - '0';
            if (node.children[i] == null)
                break;
            node = node.children[i];
            ++prefixLength;
        }
        return prefixLength;
    }
}

public class LC3043 {
    public static void main(String[] args) {
        LC3043 solution = new LC3043();
        int[] arr1 = {123, 456, 789};
        int[] arr2 = {123, 457, 789};

        int result = solution.longestCommonPrefix(arr1, arr2);
        System.out.println("Longest Common Prefix Length: " + result);
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        Trie trie = new Trie();

        for (final int num : arr1)
            trie.insert(Integer.toString(num));

        for (final int num : arr2)
            ans = Math.max(ans, trie.search(Integer.toString(num)));

        return ans;
    }
}
