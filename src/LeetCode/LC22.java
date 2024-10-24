package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    static List<String> ans;

    public static void print(int open, int close, int n, String s) {
        if (s.length() == 2 * n) {
            System.out.println(s);
            ans.add(s);
            return;
        }
        if (open < n) print(open + 1, close, n, s + "(");
        if (close < open) print(open, close + 1, n, s + ")");
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        print(0, 0, n, "");
        return ans;
    }

    public static void main(String[] args) {
        LC22 lc22 = new LC22();
        List<String> result = lc22.generateParenthesis(3);
        System.out.println("Generated Parentheses: " + result);
    }
}
