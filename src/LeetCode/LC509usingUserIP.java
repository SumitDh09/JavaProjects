package LeetcodeProblems;
import java.util.Scanner;
public class LC509usingUserIP {
    public int fib(int n) {
        if (n < 2)
            return n;

        int[] dp = {0, 0, 1};

        for (int i = 2; i <= n; ++i) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1];
        }

        return dp[2];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        LC509 solution = new LC509();
        System.out.println("Fibonacci of " + n + " is: " + solution.fib(n));
    }
}
