package LeetcodeProblems;

import java.util.*;

class MakeSumDivisiblebyP {
    public static void main(String[] args) {
        MakeSumDivisiblebyP msdp = new MakeSumDivisiblebyP();
        int[] nums = {3, 1, 4, 2};
        int p = 6;
        int result = msdp.minSubarray(nums, p);
        System.out.println("Minimum length of subarray: " + result);
    }

    public int minSubarray(int[] aa, int p) {
        int n = aa.length;
        long totalSum = 0;
        for (int num : aa) {
            totalSum += num;
        }

        int target = (int) (totalSum % p);
        if (target == 0) return 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        int currentSum = 0;
        int minLength = n;

        for (int i = 0; i < n; i++) {
            currentSum = (currentSum + aa[i]) % p;
            int complement = (currentSum - target + p) % p;

            if (prefixSumMap.containsKey(complement)) {
                minLength = Math.min(minLength, i - prefixSumMap.get(complement));
            }

            prefixSumMap.put(currentSum, i);
        }

        return minLength < n ? minLength : -1;
    }
}

