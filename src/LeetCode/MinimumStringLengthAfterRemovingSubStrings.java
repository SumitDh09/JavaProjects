package LeetcodeProblems;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubStrings {
    public static void main(String[] args) {
        //stack Approach
        MinimumStringLengthAfterRemovingSubStrings stackSolution = new MinimumStringLengthAfterRemovingSubStrings();
        String s1 = "ABFCACDB";
        String s2 = "ACBBD";

        System.out.println("Stack solution - Minimum length of \"" + s1 + "\": " + stackSolution.minLength(s1));
        // Output: 2
        System.out.println("Stack solution - Minimum length of \"" + s2 + "\": " + stackSolution.minLength(s2));
        // Output: 5
    }

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (ch == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if (ch == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}