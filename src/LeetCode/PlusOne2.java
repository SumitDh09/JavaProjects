package LeetcodeProblems;

//LeetCode 66 method 2

class PlusOne2 {
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        // Test case 1: Normal increment
        int[] digits1 = {1, 2, 3};
        System.out.print("Input: ");
        printArray(digits1);
        int[] result1 = solution.plusOne(digits1);
        System.out.print("Output: ");
        printArray(result1);

        // Test case 2: Increment with carry over
        int[] digits2 = {9, 9, 9};
        System.out.print("Input: ");
        printArray(digits2);
        int[] result2 = solution.plusOne(digits2);
        System.out.print("Output: ");
        printArray(result2);
    }

    // Helper method to print arrays
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;

        // Start from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, we can simply increment it and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the digit is 9, set it to 0 and continue to the next digit
            digits[i] = 0;
        }

        // If we're here, it means all digits were 9
        // We need to create a new array with an additional digit
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}