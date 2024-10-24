package LeetcodeProblems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximalScoreAfterApplyingKoperations {
    public static void main(String[] args) {
        MaximalScoreAfterApplyingKoperations obj = new MaximalScoreAfterApplyingKoperations();
        int[] nums = {10, 20, 30, 40, 50}; // Example input
        int k = 3; // Example number of operations
        long result = obj.maxKelements(nums, k);
        System.out.println("Maximum score after applying " + k + " operations: " + result);
    }

    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (final int num : nums)
            maxHeap.offer(num);

        for (int i = 0; i < k; ++i) {
            final int num = maxHeap.poll();
            ans += num;
            maxHeap.offer((num + 2) / 3);
        }

        return ans;
    }
}
