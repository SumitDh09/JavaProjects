package LeetcodeProblems;

class ArrayPairs {
    // Main method for testing
    public static void main(String[] args) {
        ArrayPairs solution = new ArrayPairs();

        // Test cases
        int[] arr1 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k1 = 5;
        System.out.println("Test case 1: " + solution.canArrange(arr1, k1)); // Expected: true

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int k2 = 7;
        System.out.println("Test case 2: " + solution.canArrange(arr2, k2)); // Expected: true

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int k3 = 10;
        System.out.println("Test case 3: " + solution.canArrange(arr3, k3)); // Expected: false

        // Additional test case with larger input
        int[] arr4 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr4[i] = i + 1;
        }
        int k4 = 5;
        System.out.println("Test case 4 (large input): " + solution.canArrange(arr4, k4)); // Expected: true
    }

    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];

        // Count the frequency of each remainder
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            frequency[remainder]++;
        }

        // Check if the array can be arranged into pairs
        if (frequency[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (frequency[i] != frequency[k - i]) {
                return false;
            }
        }

        return true;
    }
}


