package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

class SolutiMinimumNumberofSwaps {
    public static void main(String[] args) {
        SolutiMinimumNumberofSwaps solution = new SolutiMinimumNumberofSwaps();
        String s = "[]][[";
        System.out.println("Minimum number of swaps: " + solution.minSwaps(s));
    }

    public int minSwaps(String s) {
        int n = s.length();
        int unmatchedOpen = 0;
        List<Integer> unmatchedClose = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                unmatchedOpen++;
            } else if (unmatchedOpen > 0) {
                unmatchedOpen--;
            } else {
                unmatchedClose.add(i);
            }
        }

        return (unmatchedClose.size() + 1) / 2;
    }
}
