package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

class MaxNumberofKSum {
    public static void main(String[] args) {
        MaxNumberofKSum solution = new MaxNumberofKSum();

        //cases
        int[] test1 = {1, 2, 3, 4};
        int k1 = 5;
        int[] test2 = {3, 1, 3, 4, 3};
        int k2 = 6;

        System.out.println("Test 1: " + solution.maxOperations(test1, k1));
        // Output: 2
        System.out.println("Test 2: " + solution.maxOperations(test2, k2));
        // Output: 1
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int operations = 0;


        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the unique numbers
        for (int num : frequencyMap.keySet()) {
            int complement = k - num;

            // If the number can pair with itself
            if (num == complement) {
                operations += frequencyMap.get(num) / 2;
            }
            // If the number can pair with its complement
            else if (frequencyMap.containsKey(complement)) {
                int minFreq = Math.min(frequencyMap.get(num), frequencyMap.get(complement));
                operations += minFreq;
                frequencyMap.put(num, frequencyMap.get(num) - minFreq);
                frequencyMap.put(complement, frequencyMap.get(complement) - minFreq);
            }
        }

        return operations;
    }
}
