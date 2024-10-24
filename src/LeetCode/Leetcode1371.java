package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

class Leetcode1371 {
    public int findTheLongestSubstring(String s) {
            final String kVowels = "aeiou";
            int ans = 0;
            int prefix = 0; // Binary prefix representing vowel counts
            Map<Integer, Integer> prefixToIndex = new HashMap<>();
            prefixToIndex.put(0, -1); // Initialize with prefix 0 at index -1

            for (int i = 0; i < s.length(); ++i) {
                final int index = kVowels.indexOf(s.charAt(i));
                if (index != -1) {
                    prefix ^= 1 << index; // Toggle the bit corresponding to the vowel
                }
                prefixToIndex.putIfAbsent(prefix, i);
                ans = Math.max(ans, i - prefixToIndex.get(prefix));
            }

            return ans;
        }

        public static void main(String[] args) {
            Leetcode1371 solution = new Leetcode1371();
            String testString = "yisdyfsidouyoroep";
            int result = solution.findTheLongestSubstring(testString);
            System.out.println("The length of the longest substring with even counts of vowels is: " + result);
        }
    }
