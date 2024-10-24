package LeetcodeProblems;

public class Number1Bits {
    public static void main(String[] args) {
        Number1Bits number1Bits = new Number1Bits();

        // Test with an example input
        int testValue = 29; // Binary: 11101, which has 4 ones
        int result = number1Bits.hammingWeight(testValue);

        System.out.println("The number of 1-bits in " + testValue + " is: " + result);

        // You can add^n more test cases as needed
    }

    /**
     * This method calculates the number of 1-bits in the binary representation of a number.
     * Treats the input number as an unsigned value.
     *
     * @param n - The input integer (considered as unsigned) to count the 1-bits in.
     * @return The number of 1s in the binary representation of n.
     */
    public int hammingWeight(int n) {
        int onesCount = 0; // Store the count of 1-bits encountered
        // Use '!=0' in the condition to ensure we process all bits of n.
        // Since Java does not support unsigned int natively, we interpret n as unsigned by comparing directly to 0.
        while (n != 0) {
            // Apply the bit manipulation trick n & (n - 1) which clears the least significant 1-bit in n.
            n &= n - 1;
            // Increment the count of 1-bits for every 1-bit cleared by the operation above.
            ++onesCount;
        }

        return onesCount; // Return the total count of 1-bits found
    }
}