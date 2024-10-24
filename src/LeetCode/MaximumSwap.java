package LeetcodeProblems;

public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        int num = 2736;
        int result = ms.maximumSwap(num);
        System.out.println("The maximum number after swap is: " + result);
    }

    public int maximumSwap(int num) {
        // Convert the number to a char array for easy manipulation
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;

        // Array to store the last occurrence of each digit
        int[] lastIndex = new int[10];
        for (int i = 0; i < n; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        // Find the leftmost digit that can be swapped for a larger digit
        for (int i = 0; i < n; i++) {
            // Check all larger digits from 9 down to the current digit
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    // Swap the digits
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;

                    // Return the result as an integer
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // If no swap is needed, return the original number
        return num;
    }
}

