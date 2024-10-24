package LeetcodeProblems;

import java.util.*;

public class ParsingABooleanExpression {
    public static void main(String[] args) {
        ParsingABooleanExpression parser = new ParsingABooleanExpression();
        String expression = "|(&(t,f,t),!(t))";
        boolean result = parser.parseBoolExpr(expression);
        System.out.println("The result of the expression " + expression + " is: " + result);
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == ')') {
                ArrayList<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop(); // remove '('
                char op = stack.pop();
                char ans = evaluate(list, op);
                stack.push(ans);
            } else {
                if (ch != ',') {
                    stack.push(ch);
                }
            }
        }
        return stack.peek() == 't';
    }

    public char evaluate(ArrayList<Character> list, char op) {
        if (op == '&') {
            if (find(list, 'f')) {
                return 'f';
            } else {
                return 't';
            }
        } else if (op == '|') {
            if (find(list, 't')) {
                return 't';
            } else {
                return 'f';
            }
        } else { // not
            return (list.get(0) == 't' ? 'f' : 't');
        }
    }

    public boolean find(ArrayList<Character> list, char val) {
        for (char ch : list) {
            if (ch == val) {
                return true;
            }
        }
        return false;
    }
}
