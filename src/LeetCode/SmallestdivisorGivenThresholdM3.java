package LeetcodeProblems;

public class SmallestdivisorGivenThresholdM3 {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
        }
        int d;
        for (d = 1; d <= mx; d++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] % d == 0) sum += nums[i] / d;
                else sum += nums[i] / d + 1;
            }
            if (sum <= threshold)
                return d;
        }
        return d;
    }

    public static void main(String[] args) {
        SmallestdivisorGivenThresholdM3 sd = new SmallestdivisorGivenThresholdM3();
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println("Smallest Divisor: " + sd.smallestDivisor(nums, threshold));
    }
}
