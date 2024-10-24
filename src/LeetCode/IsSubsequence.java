package LeetcodeProblems;

class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence solution = new IsSubsequence();

        // Test cases
        System.out.println("Test case 1: " + solution.isSubsequence("abc", "ahbgdc")); // Expected: true
        System.out.println("Test case 2: " + solution.isSubsequence("axc", "ahbgdc")); // Expected: false
        System.out.println("Test case 3: " + solution.isSubsequence("", "ahbgdc")); // Expected: true
        System.out.println("Test case 4: " + solution.isSubsequence("acb", "ahbgdc")); // Expected: false
        System.out.println("Test case 5: " + solution.isSubsequence("abc", "abc")); // Expected: true
    }

    public boolean isSubsequence(String s, String t) {
        // Check if s is empty, which is always a subsequence
        if (s.isEmpty()) {
            return true;
        }

        int sIndex = 0;
        int tIndex = 0;

        // Iterate through both strings
        while (tIndex < t.length()) {
            // If characters match, move to next character in s
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                // If we've matched all characters in s, it's a subsequence
                if (sIndex == s.length()) {
                    return true;
                }
            }
            // Always move to next character in t
            tIndex++;
        }

        // If we've gone through all of t and haven't matched all of s, it's not a subsequence
        return false;
    }
}

