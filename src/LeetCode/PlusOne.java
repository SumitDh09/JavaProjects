package LeetcodeProblems;

//LeetCode 66

class PlusOne {
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        // Test case
        int[] digits = {9, 9, 9};
        int[] result = solution.plusOne(digits);

        // Print the result
        System.out.print("Result: ");
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // If the digit is less than 9,
                // simply increment it and return the array
                digits[i]++;
                return digits;
            } else {

                // set the digit to 0 and continue with the next digit
                digits[i] = 0;
            }
        }

        // If we reach here,
        // it means there was a carry after processing all digits

        // Create a new array with an additional digit (1) at the beginning
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
