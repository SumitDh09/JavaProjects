package LeetcodeProblems;

import java.util.Stack;

class MaximumWidthRamp {
    public static void main(String[] args) {
        MaximumWidthRamp solution = new MaximumWidthRamp();
        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println("Maximum Width Ramp: " + solution.maxWidthRamp(nums));
    }

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push indices into stack in decreasing order
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Step 2: Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Step 3: Find matching elements for stack entries
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                // Step 4: Update max width
                maxWidth = Math.max(maxWidth, i - stack.pop());
            }
        }

        // Step 5: Return the maximum width
        return maxWidth;
    }
}
