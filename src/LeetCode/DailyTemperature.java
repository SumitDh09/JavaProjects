package LeetcodeProblems;

import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(temperatures);

        System.out.println("Days to wait for a warmer temperature:");
        for (int days : result) {
            System.out.print(days + " ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }

        return ans;
    }
}
