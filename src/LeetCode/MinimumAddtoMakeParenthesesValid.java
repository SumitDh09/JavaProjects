package LeetcodeProblems;

import java.util.Stack;

class MinimumAddtoMakeParenthesesValid {
    public static void main(String[] args) {
        MinimumAddtoMakeParenthesesValid solution = new MinimumAddtoMakeParenthesesValid();

        // Test cases
        String test1 = "())";
        String test2 = "(((";
        String test3 = "()";
        String test4 = "()))((";

        System.out.println("Test 1: " + solution.minAddToMakeValid(test1)); // Output: 1
        System.out.println("Test 2: " + solution.minAddToMakeValid(test2)); // Output: 3
        System.out.println("Test 3: " + solution.minAddToMakeValid(test3)); // Output: 0
        System.out.println("Test 4: " + solution.minAddToMakeValid(test4)); // Output: 4
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If current character is ')' and stack top is '(', pop it (valid pair)
            if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                // Otherwise, push the character to the stack
                stack.push(ch);
            }
        }

        // Stack size will be the number of unmatched parentheses
        return stack.size();
    }
}

