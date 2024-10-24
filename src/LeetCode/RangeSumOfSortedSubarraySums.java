package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarraySums {

    // Function to generate all subarray sums
    private static List<Integer> generateSubarraySums(int[] nums) {
        List<Integer> subarraySums = new ArrayList<>();

        // Iterate over all possible subarrays
        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                subarraySums.add(currentSum);
            }
        }

        return subarraySums;
    }

    // Function to calculate the range sum of sorted subarray sums
    public static int rangeSumOfSortedSubarraySums(int[] nums, int left, int right) {
        // Generate and sort subarray sums
        List<Integer> subarraySums = generateSubarraySums(nums);
        Collections.sort(subarraySums);

        // Compute the range sum (1-based index)
        int rangeSum = 0;
        for (int i = left - 1; i < right; i++) {
            rangeSum += subarraySums.get(i);
        }

        return rangeSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int left = 1;
        int right = 5;

        int result = rangeSumOfSortedSubarraySums(nums, left, right);
        System.out.println("Range Sum: " + result); // Output depends on the example
    }
}
